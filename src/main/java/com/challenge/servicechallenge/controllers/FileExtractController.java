package com.challenge.servicechallenge.controllers;

import com.challenge.servicechallenge.dao.FileAccessor;
import com.challenge.servicechallenge.model.ListOfAccounts;
import com.challenge.servicechallenge.service.AccountListService;
import com.challenge.servicechallenge.service.FileExtractService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileExtractController {

    @Autowired
    private FileExtractService fileExtractService;
    public FileExtractController(FileExtractService fileExtractService) {
        super();
        this.fileExtractService = fileExtractService;
    }
    @GetMapping("/extractFile/{fileId}")
    JsonNode all(@PathVariable("fileId") String iden ,@RequestHeader(value = "x-refresh",defaultValue = "false") Boolean refreshIndicator) {
        return fileExtractService.extractFile(iden,refreshIndicator);
    }

}
