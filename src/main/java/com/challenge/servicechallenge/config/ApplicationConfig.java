package com.challenge.servicechallenge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@ConfigurationProperties("service")
@Data
public class ApplicationConfig {

    private final HashMap<String, String> fileConfig;

}