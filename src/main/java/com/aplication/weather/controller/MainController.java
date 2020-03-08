package com.aplication.weather.controller;

import com.aplication.weather.model.Weather;
import com.aplication.weather.model.service.DarkSky;
import com.aplication.weather.model.service.pojo.darksky.DarkSkyPOJO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @GetMapping("/todayWeather")
    public DarkSky todayWeather() throws IOException {
        DarkSky darkSky = new DarkSky();
        darkSky.getHttpResponse();

        return darkSky;

    }

    @GetMapping("/nextDayWeather")
    public Weather nextDayWeather() {
        Weather weather = new Weather();
        return weather;
    }

    @GetMapping("/topWeather")
    public Weather topWeather() {
        Weather weather = new Weather();
        return weather;
    }
}
