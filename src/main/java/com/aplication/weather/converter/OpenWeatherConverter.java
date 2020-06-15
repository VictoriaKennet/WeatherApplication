package com.aplication.weather.converter;

import com.aplication.weather.controller.MainController;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.openweather.OpenWeatherPOJO;
import com.aplication.weather.model.service.pojo.openweather.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;

public class OpenWeatherConverter implements WeatherConverter, Converter<OpenWeatherPOJO, Weathers> {

    private final static Logger logger = Logger.getLogger(OpenWeatherConverter.class);
    public String name;

    public OpenWeatherConverter(String name) {
        this.name = name;
    }

    @Override
    public Weathers toJavaObject(String https) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(https, OpenWeatherPOJO.class);
    }

    @Override
    public Weathers convert(OpenWeatherPOJO openWeatherPOJO) {
        logger.debug("OpenWeatherPOJO is converting to Weather");
        try {
            return new Weathers(name, openWeatherPOJO.getMain().getTemp() - 273,
                    openWeatherPOJO.getWeather().get(0).getDescription(), openWeatherPOJO.getWind().getSpeed(),
                    openWeatherPOJO.getWind().getDeg(), openWeatherPOJO.getClouds().getAll());
        } catch (NullPointerException e) {
            logger.error("Error: " + e);
            return null;
        }
    }
}
