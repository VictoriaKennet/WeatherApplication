package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonConverter {

    private final static Logger logger = Logger.getLogger(JsonConverter.class);

    public void toJSON(Weathers weather) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(this.getClass().getClassLoader().getResource("weather.json").getFile()), weather);
            logger.info("Add info to weather.json.");
        } catch (IOException e) {
            logger.error("Cannot add info to weather.json: " + e);
        }
    }
}
