package com.aplication.weather.model.service.pojo.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "lon",
        "lat"
})
@Data
public class Coord {
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("lat")
    private Double lat;
}
