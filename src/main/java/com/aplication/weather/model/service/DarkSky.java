package com.aplication.weather.model.service;

import com.aplication.weather.converter.DarkSkyConverter;
import com.aplication.weather.converter.JsonConverter;
import com.aplication.weather.converter.WeatherConverter;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
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
        WeatherConverter weatherConverter = new DarkSkyConverter();
        DarkSkyPOJO weather = (DarkSkyPOJO) weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
        new JsonConverter().toJSON(weather);
        return weather;
    }
}
