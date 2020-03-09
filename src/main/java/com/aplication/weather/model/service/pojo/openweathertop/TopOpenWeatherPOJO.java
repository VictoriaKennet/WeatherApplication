package com.aplication.weather.model.service.pojo.openweathertop;

import com.aplication.weather.model.Weathers;
import lombok.Data;

@Data
public class TopOpenWeatherPOJO extends Weathers {

    private Integer cod;
    private String message;
    private Integer day;
    private Temp temp;
    private Information pressure;
    private Information humidity;
    private Information wind;
    private Information precipitation;
    private Information clouds;
}
