package com.aplication.weather.model.service.pojo.darksky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Flags {

    private List<String> sources = null;
    @JsonProperty("nearest-station")
    private Double nearestStation;
    private String units;

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public Double getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(Double nearestStation) {
        this.nearestStation = nearestStation;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Flags{" +
                "sources=" + sources +
                ", nearestStation=" + nearestStation +
                ", units='" + units + '\'' +
                '}';
    }
}
