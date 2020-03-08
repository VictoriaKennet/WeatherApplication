package com.aplication.weather.model.service.pojo.weatherbit;

import com.aplication.weather.model.Weathers;

import java.util.List;
import lombok.Data;

@Data
public class WeatherBitPOJO extends Weathers {
    private List<DataWeatherBit> data = null;
    private Integer count;
}
