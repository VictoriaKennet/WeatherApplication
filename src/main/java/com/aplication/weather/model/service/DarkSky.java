package com.aplication.weather.model.service;

import com.aplication.weather.converter.WeatherConverter;
import com.aplication.weather.model.Weather;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DarkSky {


    public DarkSkyPOJO getHttpResponse() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        String http = "https://api.darksky.net/forecast/dc00ae2f7266f5910da07733e25bc378/50.9216,34.80029";
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse = httpClient.execute(httpGet);



//        ObjectMapper objectMapper = new ObjectMapper();
//        Weather weather = objectMapper.readValue(new File("config3.json"), new TypeReference<Weather>(){});

        WeatherConverter weatherConverter = new WeatherConverter();

//        DarkSkyPOJO weather = new DarkSkyPOJO();
//        weather = new WeatherConverter().toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
//        weather = new WeatherConverter().toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
//
        DarkSkyPOJO weather = weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
        weatherConverter.toJSON(weather);
        return weather;
//        return createWeather(EntityUtils.toString(httpResponse.getEntity()));
    }




}
