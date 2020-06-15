package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.*;

public class JaxbConverter {

    private final static Logger logger = Logger.getLogger(JaxbConverter.class);

    public Weathers fromXmlToObject(String filePath) {
        try {
            logger.info("Add weather from XML.");
            JAXBContext jaxbContext = newInstance(Weathers.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            logger.info("Success getting inf from file.");
            return (Weathers) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void convertObjectToXml(Weathers weather) {
        try {
            logger.info("Add weather to XML.");
            File file = new File("weather.xml");
            JAXBContext jaxbContext = newInstance(Weathers.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(weather, file);
            logger.info("Success adding inf to file.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
