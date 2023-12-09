package com.challenge.servicechallenge.exceptionHandelling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class to represent a scenario where the requested account ID is not found.
 * The @ResponseStatus annotation is used to specify the HTTP status code (404 NOT FOUND)
 * and the reason for the exception when it is thrown.
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Account ID Requested not found")
public class AccountNotFoundException extends RuntimeException {
}

