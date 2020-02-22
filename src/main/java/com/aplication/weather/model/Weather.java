package com.aplication.weather.model;

public class Weather {
    private String ID;
    private double temperature;
    private String description;
    private double windSpeed;
    private String windDirection;
    private double cloudCover;

    public Weather() {
    }

    public Weather(String ID, double temperature, String description, double windSpeed, String windDirection, double cloudCover) {
        this.ID = ID;
        this.temperature = temperature;
        this.description = description;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudCover = cloudCover;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }
}
