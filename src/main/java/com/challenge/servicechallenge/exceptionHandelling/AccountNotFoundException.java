package com.challenge.servicechallenge.exceptionHandelling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Account ID Requested not found")
public class AccountNotFoundException extends RuntimeException {
}

