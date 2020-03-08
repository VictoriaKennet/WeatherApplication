package com.aplication.weather.model.service.pojo.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

    @JsonProperty("3h")
    private Double hour;

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }
}
