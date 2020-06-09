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
@XmlRootElement
public class HourlyData {
    @JsonProperty("time")
    @XmlElement
    private Integer time;
    @JsonProperty("summary")
    @XmlElement
    private String summary;
    @JsonProperty("icon")
    @XmlElement
    private String icon;
    @JsonProperty("precipIntensity")
    @XmlElement
    private Integer precipIntensity;
    @JsonProperty("precipProbability")
    @XmlElement
    private Integer precipProbability;
    @JsonProperty("precipAccumulation")
    @XmlElement
    private Double precipAccumulation;
    @JsonProperty("precipType")
    @XmlElement
    private String precipType;
    @JsonProperty("temperature")
    @XmlElement
    private Double temperature;
    @JsonProperty("apparentTemperature")
    @XmlElement
    private Double apparentTemperature;
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
    @JsonProperty("windBearing")
    @XmlElement
    private Integer windBearing;
    @JsonProperty("cloudCover")
    @XmlElement
    private Integer cloudCover;
    @JsonProperty("uvIndex")
    @XmlElement
    private Integer uvIndex;
    @JsonProperty("visibility")
    @XmlElement
    private Integer visibility;
    @JsonProperty("ozone")
    @XmlElement
    private Double ozone;
}
