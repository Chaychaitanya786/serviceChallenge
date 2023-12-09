package com.challenge.servicechallenge.dao;

import com.challenge.servicechallenge.config.ApplicationConfig;
import com.challenge.servicechallenge.exceptionHandelling.FileServiceNotConfiguredException;
import com.challenge.servicechallenge.exceptionHandelling.ExtractFileNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * Component class responsible for accessing and caching data from files.
 * Uses the Component annotation to indicate that this class is a Spring bean.
 */

@Component
@Slf4j
public class FileAccessor {
    ApplicationConfig applicationConfig;
    private HashMap<String,String> fileConfig ;
    public FileAccessor(ApplicationConfig applicationConfig) {
        super();
        this.applicationConfig = applicationConfig;
        this.fileConfig = applicationConfig.getFileConfig();
    }
    private ObjectMapper om = new ObjectMapper();
    @Cacheable(cacheNames="files", key="#iden")
    public JsonNode extractData(String iden){
        log.info("Extracting data from file: {}",iden);
        if(!fileConfig.containsKey(iden)) {
            log.error("Invalid Service File Identifier: {}",iden);
            throw new FileServiceNotConfiguredException();
        }
        {
            try {
                File file = new File(ResourceUtils.getFile(fileConfig.get(iden)).toURI());
                return om.readTree(file);
            } catch (IOException e) {
                log.error("Service File Configured is not present/readable for Identifier: {}",iden);
                throw new ExtractFileNotFoundException();
            }
        }
    }
    @CacheEvict(value = "files", key = "#iden")
    public void evictSingleFileFromCache(String iden) {
        log.info("Evicting file from cache: {}",iden);
    }

}
