package com.challenge.servicechallenge.exceptionHandelling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "File Service Type not configured")
public class FileServiceNotConfiguredException extends RuntimeException {
    public FileServiceNotConfiguredException() {
    }
}