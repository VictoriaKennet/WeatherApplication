package com.aplication.weather.model.service.pojo.darksky;

import com.aplication.weather.model.Weathers;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonPropertyOrder({
        "latitude",
        "longitude",
        "timezone",
        "currently",
        "hourly",
        "daily",
        "flags",
        "offset"
})

@Data
@XmlRootElement
public class DarkSkyPOJO extends Weathers {
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("currently")
    private Currently currently;
    @JsonProperty("hourly")
    private Hourly hourly;
    @JsonProperty("daily")
    private Daily daily;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("offset")
    private Integer offset;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public Flags getFlags() {
        return flags;
    }

    public Integer getOffset() {
        return offset;
    }
    @XmlElement
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    @XmlElement
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    @XmlElement
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    @XmlElement
    public void setCurrently(Currently currently) {
        this.currently = currently;
    }
    @XmlElement
    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }
    @XmlElement
    public void setDaily(Daily daily) {
        this.daily = daily;
    }
    @XmlElement
    public void setFlags(Flags flags) {
        this.flags = flags;
    }
    @XmlElement
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
