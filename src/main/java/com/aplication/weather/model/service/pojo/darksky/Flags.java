package com.aplication.weather.model.service.pojo.darksky;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@JsonPropertyOrder({
        "sources",
        "nearest-station",
        "units"
})
@Data
@XmlRootElement
public class Flags {
    @JsonProperty("sources")
    @XmlElement
    private List<String> sources = null;
    @JsonProperty("nearest-station")
    @XmlElement
    private Double nearestStation;
    @JsonProperty("units")
    @XmlElement
    private String units;

}
