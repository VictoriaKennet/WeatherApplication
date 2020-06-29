package com.aplication.weather.model.service;

import com.aplication.weather.converter.MainConverter;
import com.aplication.weather.converter.WeatherBitConverter;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.weatherbit.WeatherBitPOJO;
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
public class WeatherBit implements WeatherAPI {

    private final static Logger logger = Logger.getLogger(WeatherBit.class);

    @Value(value = "${api.weather.weatherbit.name}")
    private String name;
    @Value(value = "${api.weather.weatherbit.key}")
    private String key;

    @Override
    public Weathers getHttpResponse(String city, String saveType) {
        HttpClient httpClient = HttpClients.createDefault();
        logger.info("Get http httpResponse WeatherBit.");
        String http = "https://api.weatherbit.io/v2.0/current?city=" + city + "&key=" + key;
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpGet);
            WeatherBitConverter weatherBitConverter = new WeatherBitConverter(name);
            String result = "";
            if (httpResponse.getEntity() != null) {
                result = EntityUtils.toString(httpResponse.getEntity());
            }
            WeatherBitPOJO weather = (WeatherBitPOJO) weatherBitConverter.toJavaObject(result);
            new MainConverter().mainConverter(saveType, weatherBitConverter.convert(weather));
            logger.info("Success WeatherBit!");
            return weatherBitConverter.convert(weather);
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
