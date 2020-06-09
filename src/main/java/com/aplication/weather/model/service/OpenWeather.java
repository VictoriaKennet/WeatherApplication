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
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenWeather implements WeatherAPI {

    private final static Logger logger = Logger.getLogger(OpenWeather.class);

    @Override
    public Weathers getHttpResponse(String city, String saveType) {
        HttpClient httpClient = HttpClients.createDefault();
        logger.info("Get http + httpResponse");
        String http = "http://api.openweathermap.org/data/2.5/weather?q=sumy&APPID=e17996a125b9134b4d6191a6491a1049";
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            WeatherConverter weatherConverter = new OpenWeatherConverter();
            OpenWeatherPOJO weather;
            weather = (OpenWeatherPOJO) weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
            new MainConverter().mainConverter(saveType, weather);
            return weather;
        } catch (IOException e) {
            logger.error("Cannot get weather: " + e);
            return null;
        }
    }

    public TopOpenWeatherPOJO getHttpResponseTop() {
        HttpClient httpClient = HttpClients.createDefault();
        logger.info("Get http + httpResponse");
        String http = "https://history.openweathermap.org/data/2.5/aggregated/year?q=sumy&appid=e17996a125b9134b4d6191a6491a1049";
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            WeatherConverter weatherConverter = new TopOpenWeatherConverter();
            TopOpenWeatherPOJO weather = null;
            weather = (TopOpenWeatherPOJO) weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
            new JsonConverter().toJSON(weather);
            return weather;
        } catch (IOException e) {
            logger.error("Cannot get weather: " + e);
            return null;
        }
    }
}
