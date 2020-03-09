package com.aplication.weather.model.service;

import com.aplication.weather.converter.WeatherBitConverter;
import com.aplication.weather.converter.WeatherConverter;
import com.aplication.weather.model.service.pojo.weatherbit.WeatherBitPOJO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WeatherBit {

    public WeatherBitPOJO getHttpResponse() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        String http = "https://api.weatherbit.io/v2.0/current?city=sumy&key=4e6a6c68f2fd4beda80bd209559104e4";
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        WeatherConverter weatherConverter = new WeatherBitConverter();
        WeatherBitPOJO weather = (WeatherBitPOJO) weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
        weatherConverter.toJSON(weather);
        return weather;
    }
}