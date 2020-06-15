package com.aplication.weather.model.service.pojo.weatherbit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "rh",
        "pod",
        "lon",
        "pres",
        "timezone",
        "obTime",
        "countryCode",
        "clouds",
        "ts",
        "solarRad",
        "stateCode",
        "cityName",
        "windSpd",
        "lastObTime",
        "windCdirFull",
        "windCdir",
        "slp",
        "vis",
        "hAngle",
        "sunset",
        "dni",
        "dewpt",
        "snow",
        "uv",
        "precip",
        "windDir",
        "sunrise",
        "ghi",
        "dhi",
        "aqi",
        "lat",
        "weather",
        "datetime",
        "temp",
        "station",
        "elevAngle",
        "appTemp"
})
@Data
public class DataWeatherBit {
    @JsonProperty("rh")
    private Integer rh;
    @JsonProperty("pod")
    private String pod;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("pres")
    private Double pres;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("ob_time")
    private String obTime;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("clouds")
    private Integer clouds;
    @JsonProperty("ts")
    private Integer ts;
    @JsonProperty("solar_rad")
    private Integer solarRad;
    @JsonProperty("state_code")
    private String stateCode;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("wind_spd")
    private Double windSpd;
    @JsonProperty("last_ob_time")
    private String lastObTime;
    @JsonProperty("wind_cdir_full")
    private String windCdirFull;
    @JsonProperty("wind_cdir")
    private String windCdir;
    @JsonProperty("slp")
    private Double slp;
    @JsonProperty("vis")
    private Double vis;
    @JsonProperty("h_angle")
    private Integer hAngle;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("dni")
    private Integer dni;
    @JsonProperty("dewpt")
    private Double dewpt;
    @JsonProperty("snow")
    private Integer snow;
    @JsonProperty("uv")
    private Integer uv;
    @JsonProperty("precip")
    private Integer precip;
    @JsonProperty("wind_dir")
    private Integer windDir;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("ghi")
    private Integer ghi;
    @JsonProperty("dhi")
    private Integer dhi;
    @JsonProperty("aqi")
    private Integer aqi;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("weather")
    private WeatherData weather;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("station")
    private String station;
    @JsonProperty("elev_angle")
    private Double elevAngle;
    @JsonProperty("app_temp")
    private Double appTemp;

    public Integer getClouds() {
        return clouds;
    }

    public Double getWindSpd() {
        return windSpd;
    }

    public Integer getWindDir() {
        return windDir;
    }

    public WeatherData getWeather() {
        return weather;
    }

    public Double getTemp() {
        return temp;
    }
}
