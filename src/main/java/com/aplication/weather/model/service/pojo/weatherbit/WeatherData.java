package com.aplication.weather.model.service.pojo.weatherbit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "icon",
        "code",
        "description"
})
@Data
public class WeatherData {
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("code")
    private String code;
    @JsonProperty("description")
    private String description;

    public String getDescription() {
        return description;
    }
}
