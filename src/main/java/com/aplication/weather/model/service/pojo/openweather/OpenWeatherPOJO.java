package com.aplication.weather.model.service.pojo.openweather;

import com.aplication.weather.model.Weathers;
import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherPOJO extends Weathers {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private Integer dt;
    private Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
}
