package com.aplication.weather.converter;

import com.aplication.weather.controller.MainController;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;

public class DarkSkyConverter implements WeatherConverter, Converter<DarkSkyPOJO, Weathers> {

    private final static Logger logger = Logger.getLogger(DarkSkyConverter.class);
    public String name;

    public DarkSkyConverter(String name) {
        this.name = name;
    }

    @Override
    public Weathers toJavaObject(String https) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(https, DarkSkyPOJO.class);
    }

    @Override
    public Weathers convert(DarkSkyPOJO darkSkyPOJO) {
        logger.debug("DarkSkyPOJO is converting to weather");
        try {
            return new Weathers(name, (darkSkyPOJO.getCurrently().getTemperature() - 32) * 5 / 9,
                    darkSkyPOJO.getCurrently().getSummary(),
                    darkSkyPOJO.getCurrently().getWindSpeed() * 0.44704,
                    darkSkyPOJO.getCurrently().getWindBearing(),
                    darkSkyPOJO.getCurrently().getCloudCover() * 100);
        } catch (NullPointerException e) {
            logger.error("Error: " + e);
            return null;
        }
    }
}
