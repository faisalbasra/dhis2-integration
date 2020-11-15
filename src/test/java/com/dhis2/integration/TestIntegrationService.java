package com.dhis2.integration;

import com.dhis2.integration.beans.elements.DataElements;
import com.dhis2.integration.beans.group.DataElementGroups;
import com.dhis2.integration.controller.IntegrationController;
import com.dhis2.integration.service.IntegrationService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

import org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.File;
import java.io.IOException;

@SpringBootTest
@WithMockUser
public class TestIntegrationService {
    private static final Logger logger = LoggerFactory.getLogger(TestIntegrationService.class);

    @Mock
    private IntegrationService service;

    @InjectMocks // auto inject helloRepository
    private IntegrationController controller;

    @BeforeEach
    void setMockOutput() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        DataElements dataElements = objectMapper.readValue(new File("src/test/resources/dataElements.json"), DataElements.class);
        DataElementGroups dataElementGroups = objectMapper.readValue(new File("src/test/resources/dataElementGroups.json"), DataElementGroups.class);

        when(service.getDataElements()).thenReturn(dataElements);
        when(service.getDataElementGroups()).thenReturn(dataElementGroups);
    }

    @DisplayName("Test Mock Integration Serivce for Data Elements")
    @Test
    void testdataElements() {
        ResponseEntity<DataElements> responseEntity = controller.getDataElement();
        DataElements dataElements = responseEntity.getBody();
        logger.info("Testing Data Elements Mock");
        assertNotNull("Check dataElements", dataElements);
        assertNotNull("Check Elements",dataElements.getDataElements());
        logger.info("Element size:" +dataElements.getDataElements().size());
    }

    @DisplayName("Test Mock Integration Serivce for Data Element Groups")
    @Test
    void testdataElementGroups() {
        ResponseEntity<DataElementGroups> responseEntity = controller.getDataElementGroups();
        DataElementGroups dataElementGroups = responseEntity.getBody();
        logger.info("Testing Data Element Groups Mock");
        assertNotNull("Check dataElementGroups", dataElementGroups);
        assertNotNull("Check Data Element Groups",dataElementGroups.getDataElementGroups());
        logger.info("Element Groups Size: " +dataElementGroups.getDataElementGroups().size());
    }

}
