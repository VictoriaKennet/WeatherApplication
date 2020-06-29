package com.aplication.weather.model.service;

import com.aplication.weather.converter.*;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.openweather.OpenWeatherPOJO;
import com.aplication.weather.model.service.pojo.openweathertop.TopOpenWeatherPOJO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenWeather implements WeatherAPI {

    private final static Logger logger = Logger.getLogger(OpenWeather.class);

    @Value(value = "${api.weather.openweather.name}")
    private String name;
    @Value(value = "${api.weather.openweathermap.key}")
    private String key;

    @Override
    public Weathers getHttpResponse(String city, String saveType) {

        HttpClient httpClient = HttpClients.createDefault();
        logger.info("Get http httpResponse from OpenWeather");
        String http = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=" + key;
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpGet);
            WeatherConverter weatherConverter = new OpenWeatherConverter(name);
            OpenWeatherPOJO weather = (OpenWeatherPOJO) weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
            OpenWeatherConverter openWeatherConverter = new OpenWeatherConverter(name);
            new MainConverter().mainConverter(saveType, openWeatherConverter.convert(weather));
            logger.info("Success OpenWeather!");
            return openWeatherConverter.convert(weather);
        } catch (IOException e) {
            logger.error("Cannot get weather: " + e);
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
