package com.aplication.weather.controller;

import com.aplication.weather.model.Weather;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @GetMapping("/todayWeather")
    public Weather todayWeather() throws IOException {
        Weather weather = new Weather();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://community-open-weather-map.p.rapidapi.com/weather?lat=34.80029&lon=50.9216&callback=sumy&id=2172797&lang=en&units=metric&q=Sumy%252CUkraine")
                .get()
                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "b26509b3aamsh3d8a4988cb96eb8p1a8cefjsnd0c8f941c941")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response);

        return weather;
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
