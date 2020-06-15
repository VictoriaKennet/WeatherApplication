package com.aplication.weather.model.service.pojo.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "id",
        "main",
        "description",
        "icon"
})
@Data
public class Weather {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;


    public String getDescription() {
        return description;
    }
}
