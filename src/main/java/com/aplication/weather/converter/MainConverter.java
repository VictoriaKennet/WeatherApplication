package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import com.aplication.weather.model.service.WeatherAPI;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;

public class MainConverter {

    public void mainConverter (String saveType, Weathers weather) throws FileNotFoundException {
        switch (saveType) {
            case "xml":
                new JaxbConverter().convertObjectToXml(weather);
                break;
            default:
                new JsonConverter().toJSON(weather);
                break;
        }
    }

    public ResponseEntity<InputStreamResource> getDocument(WeatherAPI weatherAPI, String city, String saveType) {
        WeatherAPI weatherApi = weatherAPI;
        Weathers weather = weatherApi.getHttpResponse(city,saveType);
        DocConverter weatherToDoc = new DocConverter();
        byte[] doc = weatherToDoc.writeWeatherToDocByTemplate(weather);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "Weather.docx");
        headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document"));
        headers.setContentLength(doc.length);
        InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(doc));
        return ResponseEntity.ok().headers(headers).body(inputStreamResource);
    }

}
