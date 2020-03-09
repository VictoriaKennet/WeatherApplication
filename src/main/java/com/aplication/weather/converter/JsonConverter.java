package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonConverter {
    String baseFile = "weather.json";

    public void toJSON(Weathers weather) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), weather);
    }
}
