package com.aplication.weather.model.service.pojo.darksky;

import com.aplication.weather.model.Weathers;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "latitude",
        "longitude",
        "timezone",
        "currently",
        "hourly",
        "daily",
        "flags",
        "offset"
})
@Data
public class DarkSkyPOJO extends Weathers {
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("currently")
    private Currently currently;
    @JsonProperty("hourly")
    private Hourly hourly;
    @JsonProperty("daily")
    private Daily daily;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("offset")
    private Integer offset;
}
