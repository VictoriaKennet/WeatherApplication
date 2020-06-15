package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.DarkSky;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonConverter {

    private final static Logger logger = Logger.getLogger(JsonConverter.class);
    private String baseFile = "weather.json";

    public void toJSON(Weathers weather) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(baseFile), weather);
            logger.info("Add info to weather.json.");
        } catch (IOException e) {
            logger.error("Cannot add info to weather.json: " + e);
        }
    }
}
