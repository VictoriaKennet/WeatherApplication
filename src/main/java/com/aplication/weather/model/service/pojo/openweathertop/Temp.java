package com.aplication.weather.model.service.pojo.openweathertop;

import lombok.Data;

@Data
public class Temp {

    private Double record_min;
    private Double record_max;
    private Double average_min;
    private Double average_max;
    private Double median;
    private Double mean;
    private Double p25;
    private Double p75;
    private Double st_dev;
    private Integer num;
}
