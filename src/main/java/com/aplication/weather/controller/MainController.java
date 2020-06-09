package com.aplication.weather.controller;

import com.aplication.weather.model.Weathers;
import org.apache.log4j.Logger;
import com.aplication.weather.model.service.DarkSky;
import com.aplication.weather.model.service.OpenWeather;
import com.aplication.weather.model.service.WeatherAPI;
import com.aplication.weather.model.service.WeatherBit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RestController
public class MainController {

    private final static Logger logger = Logger.getLogger(MainController.class);
    @Value(value = "${api.weather.numberofthread}")
    private int numberOfThread;
    private final List<WeatherAPI> list;
    private OpenWeather openWeather;
    private WeatherBit weatherBit;
    private DarkSky darkSky;

    @Autowired
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
    public DarkSky darkSky(@RequestParam(defaultValue = "json") String saveType,
                           @RequestParam(defaultValue = "sumy") String city) {

        darkSky.getHttpResponse(city,saveType);
        logger.info("Description darkSky: " + darkSky.toString());
        return darkSky;
    }

//    @GetMapping("/openWeather")
//    public OpenWeather openWeather(@RequestParam(defaultValue = "sumy") String city) {
//        openWeather.getHttpResponse(city);
//        logger.info("Description openWeather: " + openWeather.toString());
//        return openWeather;
//    }
//
//    @GetMapping("/weatherBit")
//    public WeatherBit weatherBit(@RequestParam(defaultValue = "sumy") String city) {
//        weatherBit.getHttpResponse(city);
//        logger.info("Description weatherBit: " + weatherBit.toString());
//        return weatherBit;
//    }

    @GetMapping("/topWeather")
    public OpenWeather topWeather() {
        openWeather.getHttpResponseTop();
        logger.info("Description topWeather: " + openWeather.toString());
        return openWeather;
    }

    @GetMapping("/list")
    public List<Weathers> allWeather(@RequestParam(defaultValue = "json") String saveType,
                                     @RequestParam(defaultValue = "sumy") String city) {
        logger.info("Getting weather description from  all weather API");
        ExecutorService executorService =
                Executors.newFixedThreadPool(numberOfThread);

        ExecutorCompletionService<Weathers> completionService
                = new ExecutorCompletionService<>(executorService);
        List<Weathers> weatherList = new ArrayList<>();
        for (WeatherAPI temp: list) {
            Future<Weathers> submit = null;
            try {
                submit = completionService.submit(() -> temp.getHttpResponse(city,saveType));
            } catch (NullPointerException e) {
                logger.error("Error: " + e);
            }
            try {
                assert submit != null;
                weatherList.add(submit.get());
            } catch (InterruptedException | ExecutionException | NullPointerException e) {
                logger.error("Error: " + e);
            }
        }
        logger.info("Description of all weather.");
        return weatherList;
    }
}
