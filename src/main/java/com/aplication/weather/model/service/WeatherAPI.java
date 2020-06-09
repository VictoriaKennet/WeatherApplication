package com.aplication.weather.model.service;

import com.aplication.weather.model.Weathers;

@FunctionalInterface
public interface WeatherAPI {
    Weathers getHttpResponse(String city, String saveType);
}
