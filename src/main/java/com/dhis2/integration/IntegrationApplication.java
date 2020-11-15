package com.dhis2.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class IntegrationApplication {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
        logger.info("Booting up DHIS2 Integration App ->>>");
    }
}
