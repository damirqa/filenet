package ru.damirqa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Класс описывает работру парсера JAXB
 */
public class ParserJAXB {
	
	private static Logger logger = LoggerFactory.getLogger(ParserJAXB.class);

	public static void unmarshal(File file, Class<?> objectClass) throws JAXBException{	
		try {
			JAXBContext context = JAXBContext.newInstance(objectClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			logger.info(e.getMessage());
		}
	}
	
	public static String marshal(Object object, Class<?> objectClass) {
		try {
			StringWriter string = new StringWriter();
			
			JAXBContext context = JAXBContext.newInstance(objectClass);
			Marshaller marshaller = context.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			marshaller.marshal(object, string);
			return string.toString();
		} catch (JAXBException e) {
			logger.info(e.getMessage());
		}
		return null;
	}
}
