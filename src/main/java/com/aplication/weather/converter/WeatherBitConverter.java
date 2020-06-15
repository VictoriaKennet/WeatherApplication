package com.aplication.weather.converter;

import com.aplication.weather.controller.MainController;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.WeatherBit;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
import com.aplication.weather.model.service.pojo.weatherbit.WeatherBitPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;

public class WeatherBitConverter implements WeatherConverter, Converter<WeatherBitPOJO, Weathers> {

    private final static Logger logger = Logger.getLogger(WeatherBitConverter.class);
    public String name;

    public WeatherBitConverter(String name) {
        this.name = name;
    }

    @Override
    public Weathers toJavaObject(String https) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(https, WeatherBitPOJO.class);
    }

    @Override
    public Weathers convert(WeatherBitPOJO weatherBitPOJO) {
        logger.debug("WeatherBitPOJO is converting to Weather");
        try {
            return new Weathers(name, weatherBitPOJO.getData().get(0).getTemp(),
                    weatherBitPOJO.getData().get(0).getWeather().getDescription(),
                    weatherBitPOJO.getData().get(0).getWindSpd(),
                    weatherBitPOJO.getData().get(0).getWindDir(),
                    weatherBitPOJO.getData().get(0).getClouds());
        } catch (NullPointerException e) {
            logger.error("Error: " + e);
            return null;
        }
    }
}
