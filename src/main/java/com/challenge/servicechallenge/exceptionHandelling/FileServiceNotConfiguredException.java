package com.challenge.servicechallenge.exceptionHandelling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class to represent a scenario where the file service type is not configured.
 * The @ResponseStatus annotation is used to specify the HTTP status code (400 BAD REQUEST)
 * and the reason for the exception when it is thrown.
 */

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "File Service Type not configured")
public class FileServiceNotConfiguredException extends RuntimeException {
    public FileServiceNotConfiguredException() {
    }
}
