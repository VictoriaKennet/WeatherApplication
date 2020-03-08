package com.aplication.weather.model.service.pojo.openweather;

import lombok.Data;

@Data
public class Weather {
    private Integer id;
    private String main;
    private String description;
    private String icon;
}
