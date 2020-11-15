
package com.dhis2.integration.beans.group;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataElementGroups"
})
public class DataElementGroups implements Serializable {

    @JsonProperty("dataElementGroups")
    private List<DataElementGroup> dataElementGroups = null;


    @JsonProperty("dataElementGroups")
    public List<DataElementGroup> getDataElementGroups() {
        return dataElementGroups;
    }

    @JsonProperty("dataElementGroups")
    public void setDataElementGroups(List<DataElementGroup> dataElementGroups) {
        this.dataElementGroups = dataElementGroups;
    }

}
