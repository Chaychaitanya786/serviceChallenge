package com.challenge.servicechallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ListOfAccounts {
    private final List<Account> accounts;
    private final Double total;
}
