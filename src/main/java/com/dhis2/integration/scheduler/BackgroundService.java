package com.dhis2.integration.scheduler;

import com.dhis2.integration.IntegrationApplication;
import com.dhis2.integration.service.IntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Configuration
@EnableScheduling
public class BackgroundService {
    private static final Logger logger = LoggerFactory.getLogger(BackgroundService.class);

    private IntegrationService integrationService;

    @Autowired
    public BackgroundService(IntegrationService integrationService){
        this.integrationService = integrationService;
    }

    @Scheduled(cron = "0 0/60 * 1/1 * ? ")
    public void task(){
        logger.info("Executing Scheduled Task:  " + new Date());
        integrationService.getDataElements();
        integrationService.getDataElementGroups();
    }
}
