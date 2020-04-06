package com.aplication.weather.model.service.pojo.darksky;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "time",
        "summary",
        "icon",
        "precipIntensity",
        "precipProbability",
        "precipType",
        "temperature",
        "apparentTemperature",
        "dewPoint",
        "humidity",
        "pressure",
        "windSpeed",
        "windGust",
        "windBearing",
        "cloudCover",
        "uvIndex",
        "visibility",
        "ozone"
})
@Data
public class HourlyData {
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("precipIntensity")
    private Integer precipIntensity;
    @JsonProperty("precipProbability")
    private Integer precipProbability;
    @JsonProperty("precipAccumulation")
    private Double precipAccumulation;
    @JsonProperty("precipType")
    private String precipType;
    @JsonProperty("temperature")
    private Double temperature;
    @JsonProperty("apparentTemperature")
    private Double apparentTemperature;
    @JsonProperty("dewPoint")
    private Double dewPoint;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("windSpeed")
    private Double windSpeed;
    @JsonProperty("windGust")
    private Double windGust;
    @JsonProperty("windBearing")
    private Integer windBearing;
    @JsonProperty("cloudCover")
    private Integer cloudCover;
    @JsonProperty("uvIndex")
    private Integer uvIndex;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("ozone")
    private Double ozone;
}
