package com.aplication.weather.converter;

import com.aplication.weather.model.Weathers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.*;

public class JaxbConverter {


    public Weathers fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = newInstance(Weathers.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Weathers) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    public void convertObjectToXml(Weathers weather) {
        try {

            File file = new File("file.xml");



            JAXBContext jaxbContext = newInstance(Weathers.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(weather, file);
            jaxbMarshaller.marshal(weather, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
