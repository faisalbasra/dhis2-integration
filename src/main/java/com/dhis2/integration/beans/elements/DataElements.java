
package com.dhis2.integration.beans.elements;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dataElements"
})
@ApiModel("The DataElements model used to used to map response JSON from DHIS2 service to DataElements bean")
public class DataElements implements Serializable {

    @JsonProperty("dataElements")
    @ApiModelProperty("The List<DataElement> to hold all data elements in the model list property.")
    private List<DataElement> dataElements = null;


    @JsonProperty("dataElements")
    public List<DataElement> getDataElements() {
        return dataElements;
    }

    @JsonProperty("dataElements")
    public void setDataElements(List<DataElement> dataElements) {
        this.dataElements = dataElements;
    }


}
