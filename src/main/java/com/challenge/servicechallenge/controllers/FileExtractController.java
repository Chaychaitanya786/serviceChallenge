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

/**
 * Controller class for handling HTTP requests related to file extraction.
 * Used the RestController annotation to indicate that this class is a controller
 * It returns the values of its methods should be automatically converted to JSON.
 */

@RestController
public class FileExtractController {

    @Autowired
    private FileExtractService fileExtractService;

    /**
     * Constructor for injecting the FileExtractService dependency.
     *
     * @param fileExtractService The service responsible for file extraction.
     */
    
    public FileExtractController(FileExtractService fileExtractService) {
        super();
        this.fileExtractService = fileExtractService;
    }
    /**
       * Handles HTTP GET requests for extracting information from a specified file.
       *
       * @param iden              The unique identifier of the file, provided as a path variable.
       * @param refreshIndicator  A boolean indicator is provided in the request header to force a refresh.
       *                           Defaults to false if not specified.
       * @return JsonNode         The extracted information from the specified file.
       */
    
    @GetMapping("/extractFile/{fileId}")
    JsonNode all(@PathVariable("fileId") String iden ,@RequestHeader(value = "x-refresh",defaultValue = "false") Boolean refreshIndicator) {
        return fileExtractService.extractFile(iden,refreshIndicator);
    }

}
