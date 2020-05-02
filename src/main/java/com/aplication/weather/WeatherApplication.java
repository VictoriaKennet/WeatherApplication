package com.aplication.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WeatherApplication {
    private final static Logger logger = Logger.getLogger(WeatherApplication.class);

    public static void main(String[] args) {
        logger.info("Starting weather API");
        SpringApplication.run(WeatherApplication.class, args);
    }
 }