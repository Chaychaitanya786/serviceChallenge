package com.challenge.servicechallenge.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Account {
    private Integer id;
    private String display_name;
    private String account_number;
    private Double balance;
}
