package com.aplication.weather.model.service;

import com.aplication.weather.converter.*;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.weatherbit.WeatherBitPOJO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherBit implements WeatherAPI {

    private final static Logger logger = Logger.getLogger(WeatherBit.class);

    @Override
    public Weathers getHttpResponse(String city, String saveType) {
        HttpClient httpClient = HttpClients.createDefault();
        logger.info("Get http + httpResponse");
        String http = "https://api.weatherbit.io/v2.0/current?city=sumy&key=4e6a6c68f2fd4beda80bd209559104e4";
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpGet);
            WeatherBitConverter weatherBitConverter = new WeatherBitConverter();
            WeatherBitPOJO weather = (WeatherBitPOJO) weatherBitConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));
            new MainConverter().mainConverter(saveType, weatherBitConverter.convert(weather));
            return weather;
        } catch (IOException e) {
            logger.error("Cannot get weather: " + e);
            return null;
        }
    }
}
