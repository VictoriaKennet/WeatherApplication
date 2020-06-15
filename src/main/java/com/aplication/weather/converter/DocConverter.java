package com.aplication.weather.converter;
import com.aplication.weather.model.Weathers;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class DocConverter {

    private final static org.apache.log4j.Logger logger = Logger.getLogger(DocConverter.class);
    private final File template = new File(this.getClass().getClassLoader().getResource("pattern.docx").getFile());

    public byte[] writeWeatherToDocByTemplate(Weathers weather) {
        if (weather == null) {
            return null;
        }
        logger.debug("Weather is converting to doc");
        XWPFDocument document;
        try {
            document = new XWPFDocument(OPCPackage.open(template));
        } catch (IOException | InvalidFormatException e) {
            logger.error("Error with XWPFDocument: " + e);
            return null;
        }
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            for (XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0);
                text = text.replace("API", weather.getApiName());
                text = text.replace("temperature", Double.valueOf(weather.getTemperature()).toString());
                text = text.replace("weatherdescription", weather.getWeatherDescription());
                text = text.replace("windspeed", Double.valueOf(weather.getWindSpeed()).toString());
                text = text.replace("winddigree", Double.valueOf(weather.getWindDegree()).toString());
                text = text.replace("cloudcover", Double.valueOf(weather.getCloudCover()).toString());
                run.setText(text, 0);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            document.write(stream);
        } catch (IOException e) {
            logger.error("Error with writing: " + e);
            return null;
        }
        return stream.toByteArray();
    }
}
