package ru.damirqa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ParserJAXB {
	
	private static Logger logger = LoggerFactory.getLogger(ParserJAXB.class);

	public static Object unmarshalling(File file, Class<?> objectClass) throws JAXBException{
		
		JAXBContext context;
		
		try {
			context = JAXBContext.newInstance(objectClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Object object = unmarshaller.unmarshal(file);
			return object;
		} catch (JAXBException e) {
			logger.info(e.getMessage());
		}
		return null;
	}
	
	
	
}
