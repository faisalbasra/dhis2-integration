package com.dhis2.integration.controller;

import com.dhis2.integration.beans.Echo;
import com.dhis2.integration.beans.elements.DataElements;
import com.dhis2.integration.beans.group.DataElementGroups;
import com.dhis2.integration.service.IntegrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Validated
//@RequestMapping(value = "api")
@Api(value = "Set of endpoints for Retrieving API Metadata from DHIS2", tags = "DHIS2 Integration")
public class IntegrationController {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationController.class);

    private CacheManager cacheManager;
    private IntegrationService integrationService;

    @Autowired
    public void IntegrationController(CacheManager cacheManager, IntegrationService integrationService){
        this.cacheManager = cacheManager;
        this.integrationService = integrationService;
    }

    @GetMapping(value = "/api/dataElements",produces = "application/json")
    @ApiOperation("This operation returns Data Elements in JSON from DHIS2 web service.")
    public @ResponseBody
    ResponseEntity<DataElements> getDataElement() {
        logger.info("Request Received for getDataElement");

        try{
            DataElements dataElements = integrationService.getDataElements();
            return new ResponseEntity<>(dataElements,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/api/dataElementGroups",produces = "application/json")
    @ApiOperation("This operation returns Data Element Groups in JSON from DHIS2 web service.")
    public ResponseEntity<DataElementGroups>
     getDataElementGroups() {
        logger.info("Request Received for getDataElementGroups");
        try{
            DataElementGroups dataElementGroups = integrationService.getDataElementGroups();
            return new ResponseEntity<>(dataElementGroups,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/api/echo", produces = "application/json")
    @ApiOperation("This operation is only for testing the API is running.")
    public ResponseEntity<Echo> echo(@RequestHeader HttpHeaders httpHeaders) {
        logger.info(" <Requested action Echo> "+ httpHeaders.getAccept());
        logger.info(" <Requested action Echo> "+ httpHeaders.toString());
        Echo echo = new Echo();
        echo.setTime(new Date().toString());
        echo.setMessage(httpHeaders.toString());
        return new ResponseEntity<>(echo, HttpStatus.OK);
    }
}
