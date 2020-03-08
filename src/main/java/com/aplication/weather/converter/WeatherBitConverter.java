package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.openweather.OpenWeatherPOJO;
import com.aplication.weather.model.service.pojo.weatherbit.WeatherBitPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WeatherBitConverter implements WeatherConverter{
    @Override
    public void toJSON(Weathers weather) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), weather);
    }

    @Override
    public Weathers toJavaObject(String https)  throws IOException  {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(https, WeatherBitPOJO.class);
    }
}
