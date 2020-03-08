package com.aplication.weather.model.service;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
import com.aplication.weather.model.service.pojo.openweather.Weather;

import java.io.IOException;

public interface WeatherAPI {
    Weather getHttpResponse() throws IOException;
}
