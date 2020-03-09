package com.aplication.weather.model.service;

import com.aplication.weather.converter.JsonConverter;
import com.aplication.weather.converter.OpenWeatherConverter;
import com.aplication.weather.converter.WeatherConverter;
import com.aplication.weather.model.service.pojo.openweather.OpenWeatherPOJO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenWeather {

    public OpenWeatherPOJO getHttpResponse() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        String http = "http://api.openweathermap.org/data/2.5/weather?q=sumy&APPID=e17996a125b9134b4d6191a6491a1049";
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        WeatherConverter weatherConverter = new OpenWeatherConverter();
        OpenWeatherPOJO weather = (OpenWeatherPOJO) weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
        new JsonConverter().toJSON(weather);
        return weather;
    }

}
