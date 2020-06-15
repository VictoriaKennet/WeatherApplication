package com.aplication.weather.model.service.pojo.weatherbit;

import com.aplication.weather.model.Weathers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "data",
        "count"
})
@Data
public class WeatherBitPOJO extends Weathers {
    @JsonProperty("data")
    private List<DataWeatherBit> data = null;
    @JsonProperty("count")
    private Integer count;

    public List<DataWeatherBit> getData() {
        return data;
    }
}
