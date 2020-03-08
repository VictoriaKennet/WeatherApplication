package com.aplication.weather.model.service;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;

import java.io.IOException;

public interface WeatherAPI {
    DarkSkyPOJO getHttpResponse() throws IOException;
    Weathers createWeather(String json) throws IOException;
}
