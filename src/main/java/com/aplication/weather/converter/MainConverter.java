package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;

public class MainConverter {

    public Weathers mainConverter (String saveType, Weathers weather) {

        switch (saveType) {
            case "doc":

                break;
            case "xml":
                new JaxbConverter().convertObjectToXml(weather);
                break;
            case "json":
                new JsonConverter().toJSON(weather);
                break;
            default:

                break;
        }

        return weather;
    }

}
