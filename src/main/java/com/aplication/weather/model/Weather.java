package com.aplication.weather.model;

public class Weather {
    private String ID;

    public Weather() {
    }

    public Weather(String ID, double temperature, String description, double windSpeed, String windDirection, double cloudCover) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
