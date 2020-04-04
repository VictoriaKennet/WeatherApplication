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
import java.util.concurrent.*;

@RestController
public class MainController {

    private int numberOfThread = 3;
    private final List<WeatherAPI> list;
    private OpenWeather openWeather;
    private WeatherBit weatherBit;
    private DarkSky darkSky;

    public MainController(DarkSky darkSky, OpenWeather openWeather, WeatherBit weatherBit) {
        list = new ArrayList<>();
        this.openWeather = openWeather;
        this.weatherBit = weatherBit;
        this.darkSky = darkSky;
        list.add(openWeather);
        list.add(weatherBit);
        list.add(darkSky);
    }

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
    public OpenWeather topWeather() throws IOException {
        OpenWeather openWeather = new OpenWeather();
        openWeather.getHttpResponseNEW();
        return openWeather;
    }

    @GetMapping("/list")
    public List<Weathers> allWeather() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThread);
        ExecutorCompletionService<Weathers> completionService = new ExecutorCompletionService<>(executorService);
        List<Weathers> weatherList = new ArrayList<>();
        for (WeatherAPI temp: list) {
            Future<Weathers> submit = completionService.submit(temp::getHttpResponse);
            weatherList.add(submit.get());

        }
        return weatherList;
    }
}
