package com.dhis2.integration.service;

import com.dhis2.integration.beans.elements.DataElements;
import com.dhis2.integration.beans.group.DataElementGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@CacheConfig(cacheNames = "DataElements")
public class IntegrationService {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationService.class);

    private RestTemplate restTemplate;

    @Value( "${dhis2.username}" )
    private String dhisUsername;

    @Value( "${dhis2.password}" )
    private String dhisPassword;

    @Value( "${dhis2.baseURL}" )
    private String baseURL;

    @Value( "${dhis2.dataElemenstURI}" )
    private String dataElemenstURI;

    @Value( "${dhis2.dataElementGroupURI}" )
    private String dataElementGroupURI;

    @Autowired
    public void IntegrationService(RestTemplateBuilder builder){
        this.restTemplate = builder
                .basicAuthentication(dhisUsername, dhisPassword)
                .build();
    }

    @Cacheable(value = "DataElements", key = "#root.method.name")
    public DataElements getDataElements(){
        logger.info("Getting data from DHIS Service");
        DataElements dataElements = restTemplate
                .getForObject(baseURL+dataElemenstURI, DataElements.class);
        if(dataElements!=null){
            logger.info(dataElements.getDataElements()!=null? "Elements Size: "+dataElements.getDataElements().size():" dataElements.getDataElements() is Null");
            return dataElements;
        }
        return null;
    }

    @Cacheable(value = "DateElementGroups", key = "#root.method.name")
    public DataElementGroups getDataElementGroups(){
        logger.info("Getting data from DHIS Service");
        DataElementGroups dataElementGroups = restTemplate
                .getForObject(baseURL+dataElementGroupURI, DataElementGroups.class);
        if(dataElementGroups!=null){
            logger.info(dataElementGroups.getDataElementGroups()!=null? "Elements Size: "+dataElementGroups.getDataElementGroups().size():" dataElements.getDataElements() is Null");
            return dataElementGroups;
        }
        return null;
    }
}
