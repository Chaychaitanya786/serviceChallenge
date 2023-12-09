package com.challenge.servicechallenge.service;

import com.challenge.servicechallenge.dao.FileAccessor;
import com.challenge.servicechallenge.model.Account;
import com.challenge.servicechallenge.model.ListOfAccounts;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service class for extracting data from files with optional cache eviction.
 * Uses the @Service annotation to indicate that this class is a Spring service.
 * Lombok's @Slf4j is used for logging.
 */

@Service
@Slf4j
public class FileExtractService {
    private FileAccessor fileAccessor;
    public FileExtractService(FileAccessor fileAccessor) {
        super();
        this.fileAccessor = fileAccessor;
    }
    
    /**
      * Extracts data from a specified file with an optional cache eviction based on the refresh indicator.
      * @param iden              The unique identifier of the file.
      * @param refreshIndicator A boolean indicator to force a cache refresh.
      * @return JsonNode         The extracted data from the specified file.
      */
    
    public JsonNode extractFile(String iden, Boolean refreshIndicator) {
        if(refreshIndicator)
            fileAccessor.evictSingleFileFromCache(iden);
        return fileAccessor.extractData(iden);
    }
}

