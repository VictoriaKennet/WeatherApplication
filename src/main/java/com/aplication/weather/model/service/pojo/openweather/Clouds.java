package com.aplication.weather.model.service.pojo.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "all"
})
@Data
public class Clouds {
    @JsonProperty("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }
}
