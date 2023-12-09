package com.challenge.servicechallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Model class representing a list of accounts along with a total.
 * Lombok annotations are used for the automatic generation of constructors, getters, and setters.
 */

@Data
@AllArgsConstructor
public class ListOfAccounts {
    private final List<Account> accounts;
    private final Double total;
}
