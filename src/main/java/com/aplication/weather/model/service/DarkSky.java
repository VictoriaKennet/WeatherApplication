package com.aplication.weather.model.service;

import com.aplication.weather.converter.MainConverter;
import org.apache.log4j.Logger;
import com.aplication.weather.converter.DarkSkyConverter;
import com.aplication.weather.converter.JsonConverter;
import com.aplication.weather.converter.WeatherConverter;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@PropertySource("classpath:/application.properties")
public class DarkSky implements WeatherAPI {

    private final static Logger logger = Logger.getLogger(DarkSky.class);

    @Value(value = "${api.weather.darksky.name}")
    private String name;
    @Value(value = "${api.weather.darksky.key}")
    private String key;

    @Override
    public Weathers getHttpResponse(String city, String saveType) {
        HttpClient httpClient = HttpClients.createDefault();
        logger.info("Get http + httpResponse");
        String http = "https://api.darksky.net/forecast/" + key + "/50.9216,34.80029";
        HttpGet httpGet = new HttpGet(http);
        HttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpGet);
            WeatherConverter weatherConverter = new DarkSkyConverter();
            DarkSkyPOJO weather = (DarkSkyPOJO) weatherConverter.toJavaObject(EntityUtils.toString(httpResponse.getEntity()));

            DarkSkyConverter darkSkyConverter = new DarkSkyConverter();
            new MainConverter().mainConverter(saveType, darkSkyConverter.convert(weather));

            return weather;
        } catch (IOException e) {
            logger.error("Cannot get info: " + e);
            return null;
        }
    }
}
