package com.dhis2.integration.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("This is just ECHO response to just validate, API serice is up & running.")
public class Echo {

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ApiModelProperty("Server Time to echo in response")
    private String time;
    @ApiModelProperty("Dummy static message from the server.")
    private String message;

}
