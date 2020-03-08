package com.aplication.weather.converter;

import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WeatherConverter {
    private final static String baseFile = "weather.json";

    public void toJSON(DarkSkyPOJO weather) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), weather);
        System.out.println("json created!");
    }

    public DarkSkyPOJO toJavaObject(String https)  throws IOException  {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(https, DarkSkyPOJO.class);
    }
}
