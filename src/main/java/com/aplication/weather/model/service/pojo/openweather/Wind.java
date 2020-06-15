package com.aplication.weather.model.service.pojo.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({
        "speed",
        "deg"
})
@Data
public class Wind {
    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Integer deg;

    public Double getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }
}
