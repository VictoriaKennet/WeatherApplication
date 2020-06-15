package com.aplication.weather.controller;

import com.aplication.weather.converter.DocConverter;
import com.aplication.weather.converter.MainConverter;
import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.pojo.openweather.Weather;
import org.apache.log4j.Logger;
import com.aplication.weather.model.service.DarkSky;
import com.aplication.weather.model.service.OpenWeather;
import com.aplication.weather.model.service.WeatherAPI;
import com.aplication.weather.model.service.WeatherBit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
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

    @GetMapping(value = "/darkSky", produces = { "application/json", "application/xml" })
    public Weathers darkSky(@RequestParam(defaultValue = "xml") String saveType,
                           @RequestParam(defaultValue = "sumy") String city) {
        Weathers weathers = darkSky.getHttpResponse(city,saveType);
        logger.info("Description darkSky: " + darkSky.toString());
        return weathers;
    }

    @GetMapping(value = "/openWeather", produces = { "application/json", "application/xml" })
    public Weathers openWeather(@RequestParam(defaultValue = "json") String saveType,
                                   @RequestParam(defaultValue = "sumy") String city) {
        Weathers weathers = openWeather.getHttpResponse(city,saveType);
        logger.info("Description openWeather: " + openWeather.toString());
        return weathers;
    }

    @GetMapping(value = "/weatherBit", produces = { "application/json", "application/xml" })
    public Weathers weatherBit(@RequestParam(defaultValue = "json") String saveType,
                                 @RequestParam(defaultValue = "sumy") String city) {
        Weathers weathers = weatherBit.getHttpResponse(city,saveType);
        logger.info("Description weatherBit: " + weatherBit.toString());
        return weathers;
    }

    @GetMapping(value = "/list", produces = { "application/json", "application/xml" })
    public List<Weathers> allWeather(@RequestParam(defaultValue = "json") String saveType,
                                     @RequestParam(defaultValue = "sumy") String city) {

        logger.info("Getting weather description from  all weather API");
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThread);

        ExecutorCompletionService<Weathers> completionService = new ExecutorCompletionService<>(executorService);
        List<Weathers> weatherList = new ArrayList<>();
        List<Future<Weathers>> futures = new ArrayList<>();
        for (WeatherAPI temp: list) {
            try {
                futures.add(completionService.submit(() -> temp.getHttpResponse(city,saveType)));
            } catch (NullPointerException e) {
                logger.error("Error: " + e);
            }
        }
        for (int i = 0; i < futures.size(); i++) {
            try {
                weatherList.add(futures.get(i).get());
            } catch (InterruptedException | ExecutionException | NullPointerException e) {
                logger.error("Error: " + e);
            }
        }
        logger.info("Description of all weather.");
        return weatherList;
    }

    @GetMapping(value = "/document")
    public ResponseEntity<InputStreamResource> getDoc
            (@RequestParam(defaultValue = "darkSky") String weatherAPI,
             @RequestParam(defaultValue = "sumy") String city,
             @RequestParam(defaultValue = "json") String saveType) {
        WeatherAPI weathers = null;
        switch (weatherAPI) {
            case "OpenWeather":
                weathers = openWeather;
                break;
            case "WeatherBit":
                weathers = weatherBit;
                break;
            default:
                weathers = darkSky;
                break;
        }
        MainConverter mainConverter = new MainConverter();
        return mainConverter.getDocument(weathers, city, saveType);
    }
}
