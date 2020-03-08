package com.aplication.weather.controller;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.DarkSky;
import com.aplication.weather.model.service.OpenWeather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @GetMapping("/darkSky")
    public DarkSky darkSky() throws IOException {
        DarkSky darkSky = new DarkSky();
        darkSky.getHttpResponse();
        return darkSky;
    }

    @GetMapping("/openWeather")
    public OpenWeather openWeather() throws IOException {
        OpenWeather openWeather = new OpenWeather();
        openWeather.getHttpResponse();
        return openWeather;
    }

    @GetMapping("/nextDayWeather")
    public Weathers nextDayWeather() {
        Weathers weather = new Weathers();
        return weather;
    }

    @GetMapping("/topWeather")
    public Weathers topWeather() {
        Weathers weather = new Weathers();
        return weather;
    }
}
