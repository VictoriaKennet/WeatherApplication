package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.openweather.OpenWeatherPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class OpenWeatherConverter implements WeatherConverter {

    @Override
    public Weathers toJavaObject(String https)  throws IOException  {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(https, OpenWeatherPOJO.class);
    }
}
