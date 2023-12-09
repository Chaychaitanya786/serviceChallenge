package com.challenge.servicechallenge.model;

import lombok.*;

/**
 * Model class representing an account.
 * Lombok annotations are used for the automatic generation of constructors, getters, and setters.
 */

@NoArgsConstructor
@Getter
@Setter
public class Account {
    private Integer id;
    private String display_name;
    private String account_number;
    private Double balance;
}
