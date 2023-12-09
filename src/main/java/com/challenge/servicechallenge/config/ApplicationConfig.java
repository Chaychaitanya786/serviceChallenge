package com.challenge.servicechallenge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
/**
 * Configuration class for managing application properties related to a service.
 * Annotated with @Component for automatic detection and registration as a Spring bean.
 */
@Component
@ConfigurationProperties("service")
@Data
public class ApplicationConfig {

    /**
     * HashMap to store key-value pairs related to file configuration.
     * The keys and values in this map are configured through application properties
     * prefixed with "service" in the application configuration files.
     */
    private final HashMap<String, String> fileConfig;

}
