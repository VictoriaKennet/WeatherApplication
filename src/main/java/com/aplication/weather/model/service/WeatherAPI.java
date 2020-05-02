package com.aplication.weather.model.service;

import com.aplication.weather.model.Weathers;

import java.io.IOException;

@FunctionalInterface
public interface WeatherAPI {
    Weathers getHttpResponse() throws IOException;
}
