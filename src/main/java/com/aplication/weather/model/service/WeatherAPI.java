package com.aplication.weather.model.service;

import com.aplication.weather.model.Weather;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;

import java.io.IOException;

public interface WeatherAPI {
    DarkSkyPOJO getHttpResponse() throws IOException;
    Weather createWeather(String json) throws IOException;
}
