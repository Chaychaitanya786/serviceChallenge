package com.challenge.servicechallenge.controllers;

import com.challenge.servicechallenge.model.Account;
import com.challenge.servicechallenge.model.ListOfAccounts;
import com.challenge.servicechallenge.service.AccountListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Used the RestController annotation to indicate that this class is a controller
//It return values of its methods should be automatically converted to JSON.

@RestController
public class AccountListController {

    @Autowired
    private AccountListService accountListService;
  /**
     * Handles HTTP GET requests for retrieving all accounts.
     *
     * @return ListOfAccounts containing all accounts.
     */
    
    @GetMapping("/accounts")
    ListOfAccounts all() {
        return accountListService.getAllAccounts();
    }
    //Handles HTTP GET requests for retrieving an account by its ID.
    //@param id The ID of the account to retrieve, provided as a request parameter.
    //@return Account with the specified ID.
    
    @GetMapping("/account")
    Account getAccountByID(@RequestParam int id) {
        return accountListService.getAccountByID(id);
    }

}
