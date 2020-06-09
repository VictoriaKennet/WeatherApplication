package com.aplication.weather.model.service.pojo.darksky;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonPropertyOrder({
        "time",
        "summary",
        "icon",
        "sunriseTime",
        "sunsetTime",
        "moonPhase",
        "precipIntensity",
        "precipIntensityMax",
        "precipIntensityMaxTime",
        "precipProbability",
        "precipType",
        "temperatureHigh",
        "temperatureHighTime",
        "temperatureLow",
        "temperatureLowTime",
        "apparentTemperatureHigh",
        "apparentTemperatureHighTime",
        "apparentTemperatureLow",
        "apparentTemperatureLowTime",
        "dewPoint",
        "humidity",
        "pressure",
        "windSpeed",
        "windGust",
        "windGustTime",
        "windBearing",
        "cloudCover",
        "uvIndex",
        "uvIndexTime",
        "visibility",
        "ozone",
        "temperatureMin",
        "temperatureMinTime",
        "temperatureMax",
        "temperatureMaxTime",
        "apparentTemperatureMin",
        "apparentTemperatureMinTime",
        "apparentTemperatureMax",
        "apparentTemperatureMaxTime"
})
@Data
@XmlRootElement
public class DailyData {
    @JsonProperty("time")
    @XmlElement
    private int time;
    @JsonProperty("summary")
    @XmlElement
    private String summary;
    @JsonProperty("icon")
    @XmlElement
    private String icon;
    @JsonProperty("sunriseTime")
    @XmlElement
    private Integer sunriseTime;
    @JsonProperty("sunsetTime")
    @XmlElement
    private Integer sunsetTime;
    @JsonProperty("moonPhase")
    @XmlElement
    private Double moonPhase;
    @JsonProperty("precipIntensity")
    @XmlElement
    private Double precipIntensity;
    @JsonProperty("precipIntensityMax")
    @XmlElement
    private Double precipIntensityMax;
    @JsonProperty("precipIntensityMaxTime")
    @XmlElement
    private Integer precipIntensityMaxTime;
    @JsonProperty("precipProbability")
    @XmlElement
    private Double precipProbability;
    @JsonProperty("precipAccumulation")
    @XmlElement
    private Double precipAccumulation;
    @JsonProperty("precipType")
    @XmlElement
    private String precipType;
    @JsonProperty("temperatureHigh")
    @XmlElement
    private Double temperatureHigh;
    @JsonProperty("temperatureHighTime")
    @XmlElement
    private Integer temperatureHighTime;
    @JsonProperty("temperatureLow")
    @XmlElement
    private Double temperatureLow;
    @JsonProperty("temperatureLowTime")
    @XmlElement
    private Integer temperatureLowTime;
    @JsonProperty("apparentTemperatureHigh")
    @XmlElement
    private Double apparentTemperatureHigh;
    @JsonProperty("apparentTemperatureHighTime")
    @XmlElement
    private Integer apparentTemperatureHighTime;
    @JsonProperty("apparentTemperatureLow")
    @XmlElement
    private Double apparentTemperatureLow;
    @JsonProperty("apparentTemperatureLowTime")
    @XmlElement
    private Integer apparentTemperatureLowTime;
    @JsonProperty("dewPoint")
    @XmlElement
    private Double dewPoint;
    @JsonProperty("humidity")
    @XmlElement
    private Double humidity;
    @JsonProperty("pressure")
    @XmlElement
    private Double pressure;
    @JsonProperty("windSpeed")
    @XmlElement
    private Double windSpeed;
    @JsonProperty("windGust")
    @XmlElement
    private Double windGust;
    @JsonProperty("windGustTime")
    @XmlElement
    private Integer windGustTime;
    @JsonProperty("windBearing")
    @XmlElement
    private Integer windBearing;
    @JsonProperty("cloudCover")
    @XmlElement
    private Double cloudCover;
    @JsonProperty("uvIndex")
    @XmlElement
    private Integer uvIndex;
    @JsonProperty("uvIndexTime")
    @XmlElement
    private Integer uvIndexTime;
    @JsonProperty("visibility")
    @XmlElement
    private Integer visibility;
    @JsonProperty("ozone")
    @XmlElement
    private Double ozone;
    @JsonProperty("temperatureMin")
    @XmlElement
    private Double temperatureMin;
    @JsonProperty("temperatureMinTime")
    @XmlElement
    private Integer temperatureMinTime;
    @JsonProperty("temperatureMax")
    @XmlElement
    private Double temperatureMax;
    @JsonProperty("temperatureMaxTime")
    @XmlElement
    private Integer temperatureMaxTime;
    @JsonProperty("apparentTemperatureMin")
    @XmlElement
    private Double apparentTemperatureMin;
    @JsonProperty("apparentTemperatureMinTime")
    @XmlElement
    private Integer apparentTemperatureMinTime;
    @JsonProperty("apparentTemperatureMax")
    @XmlElement
    private Double apparentTemperatureMax;
    @JsonProperty("apparentTemperatureMaxTime")
    @XmlElement
    private Integer apparentTemperatureMaxTime;
}
