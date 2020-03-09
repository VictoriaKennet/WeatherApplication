package com.aplication.weather.model.service.pojo.darksky;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonPropertyOrder({
        "sources",
        "nearest-station",
        "units"
})
@Data
public class Flags {
    @JsonProperty("sources")
    private List<String> sources = null;
    @JsonProperty("nearest-station")
    private Double nearestStation;
    @JsonProperty("units")
    private String units;

}
