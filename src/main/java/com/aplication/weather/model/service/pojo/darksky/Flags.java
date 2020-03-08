package com.aplication.weather.model.service.pojo.darksky;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class Flags {
    private List<String> sources = null;
    @JsonProperty("nearest-station")
    private Double nearestStation;
    private String units;

}
