package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.openweathertop.TopOpenWeatherPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TopOpenWeatherConverter implements WeatherConverter {
    @Override
    public Weathers toJavaObject(String https)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(https, TopOpenWeatherPOJO.class);
    }
}
