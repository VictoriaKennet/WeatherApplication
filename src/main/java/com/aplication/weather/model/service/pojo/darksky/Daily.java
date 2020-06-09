package com.aplication.weather.model.service.pojo.darksky;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@JsonPropertyOrder({
        "summary",
        "icon",
        "data"
})
@Data
@XmlRootElement
public class Daily {
    @JsonProperty("summary")
    @XmlElement
    private String summary;
    @JsonProperty("icon")
    @XmlElement
    private String icon;
    @JsonProperty("data")
    @XmlElement
    private List<DailyData> data = null;
}
