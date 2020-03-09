package com.aplication.weather.controller;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.DarkSky;
import com.aplication.weather.model.service.OpenWeather;
import com.aplication.weather.model.service.WeatherAPI;
import com.aplication.weather.model.service.WeatherBit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/weatherBit")
    public WeatherBit weatherBit() throws IOException {
        WeatherBit weatherBit = new WeatherBit();
        weatherBit.getHttpResponse();
        return weatherBit;
    }

    @GetMapping("/topWeather")
    public OpenWeather weatherBitNew() throws IOException {
        OpenWeather openWeather = new OpenWeather();
        openWeather.getHttpResponseNEW();
        return openWeather;
    }
}
