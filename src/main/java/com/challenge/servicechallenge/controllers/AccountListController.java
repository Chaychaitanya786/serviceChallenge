package com.challenge.servicechallenge.controllers;

import com.challenge.servicechallenge.model.Account;
import com.challenge.servicechallenge.model.ListOfAccounts;
import com.challenge.servicechallenge.service.AccountListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountListController {

    @Autowired
    private AccountListService accountListService;

    @GetMapping("/accounts")
    ListOfAccounts all() {
        return accountListService.getAllAccounts();
    }

    @GetMapping("/account")
    Account getAccountByID(@RequestParam int id) {
        return accountListService.getAccountByID(id);
    }

}
