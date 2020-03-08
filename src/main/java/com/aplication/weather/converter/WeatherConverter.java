package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;

import java.io.IOException;

public interface WeatherConverter {
    String baseFile = "weather.json";

    void toJSON(Weathers weather) throws IOException;

    Weathers toJavaObject(String https) throws IOException;
}
