package com.challenge.servicechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main application class for the ServiceChallenge application.
 * Uses the @SpringBootApplication annotation for auto-configuration and component scanning.
 * Enables caching with the @EnableCaching annotation.
 */

@SpringBootApplication
@EnableCaching
public class ServiceChallengeApplication {

    public static void main(String[] args) {
       
        // Start the Spring Boot application.
        SpringApplication.run(ServiceChallengeApplication.class, args);
    }

}
