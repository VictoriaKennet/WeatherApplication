package com.aplication.weather.model.service.pojo.openweathertop;

import lombok.Data;

@Data
public class Information {

    private Integer min;
    private Integer max;
    private Integer median;
    private Double mean;

    private Integer p25;
    private Integer p75;
    private Double st_dev;
    private Integer num;
}
