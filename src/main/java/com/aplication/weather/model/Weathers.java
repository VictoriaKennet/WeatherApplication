package com.aplication.weather.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weathers {

    private String apiName;
    private double temperature;
    private String weatherDescription;
    private double windSpeed;
    private double windDegree;
    private double cloudCover;

    public Weathers() {
    }

    public Weathers(String apiName, double temperature, String weatherDescription, double windSpeed, double windDegree, double cloudCover) {
        this.apiName = apiName;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.cloudCover = cloudCover;
    }


    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }
}
