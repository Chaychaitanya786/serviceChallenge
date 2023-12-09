package com.challenge.servicechallenge.service;

import com.challenge.servicechallenge.exceptionHandelling.AccountNotFoundException;
import com.challenge.servicechallenge.model.Account;
import com.challenge.servicechallenge.model.ListOfAccounts;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountListService {
    private final FileExtractService fileExtractService;
    private  final ObjectMapper objectMapper = new ObjectMapper();
    public AccountListService(FileExtractService fileExtractService) {
        super();
        this.fileExtractService=fileExtractService;
    }
    public ListOfAccounts getAllAccounts() {
        JsonNode listAccounts = fileExtractService.extractFile("listOfAccounts", false);
        List<Account> lA = objectMapper.convertValue(listAccounts, new TypeReference<List<Account>>() {});
        return new ListOfAccounts(lA, lA.stream().map(Account::getBalance).reduce(0.0, Double::sum));
    }

    public Account getAccountByID(int id) {
        JsonNode listAccounts = fileExtractService.extractFile("listOfAccounts", false);
        Optional<Account> account = objectMapper.convertValue(listAccounts, new TypeReference<List<Account>>() {}).stream().filter(act -> act.getId() == id).findFirst();
        if(account.isEmpty()) throw new AccountNotFoundException();
        return account.get();
    }
}
