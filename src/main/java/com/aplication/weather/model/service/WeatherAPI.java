package com.aplication.weather.model.service;

import com.aplication.weather.model.Weathers;

import java.io.IOException;

public interface WeatherAPI {
    Weathers getHttpResponse() throws IOException;
}
