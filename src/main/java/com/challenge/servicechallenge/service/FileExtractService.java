package com.challenge.servicechallenge.service;

import com.challenge.servicechallenge.dao.FileAccessor;
import com.challenge.servicechallenge.model.Account;
import com.challenge.servicechallenge.model.ListOfAccounts;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class FileExtractService {
    private FileAccessor fileAccessor;
    public FileExtractService(FileAccessor fileAccessor) {
        super();
        this.fileAccessor = fileAccessor;
    }

    public JsonNode extractFile(String iden, Boolean refreshIndicator) {
        if(refreshIndicator)
            fileAccessor.evictSingleFileFromCache(iden);
        return fileAccessor.extractData(iden);
    }
}

