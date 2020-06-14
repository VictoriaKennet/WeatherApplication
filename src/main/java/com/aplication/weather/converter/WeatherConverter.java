package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;

import java.io.IOException;

@FunctionalInterface
public interface WeatherConverter {
    Weathers toJavaObject(String https) throws IOException;

}
