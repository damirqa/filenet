package ru.damirqa.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.damirqa.exceptions.DocumentExistsException;
import ru.damirqa.model.Document;

/*
 * Класс Фабрика
 */
public class Factory {
	
	private final Generator generator;
	
	private static Logger logger = LoggerFactory.getLogger(Factory.class);
	
	public Factory(Generator generator) {
		this.generator = generator;
	}
	
	/*
	 * generator создает документ
	 */
	public void createDocument() {
		try {
			Document document = this.generator.createDocument();
		} catch (DocumentExistsException e) {
			logger.info(e.getMessage());
		}
	}
}