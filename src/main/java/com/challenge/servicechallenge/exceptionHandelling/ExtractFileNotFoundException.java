package com.challenge.servicechallenge.exceptionHandelling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "File Requested not found")
public class ExtractFileNotFoundException extends RuntimeException {
}

