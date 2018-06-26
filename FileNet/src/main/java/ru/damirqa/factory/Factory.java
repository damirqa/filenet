package ru.damirqa.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.damirqa.exceptions.DocumentExistsException;

/*
 * Класс Фабрика
 */
public class Factory {
	
	private Generator generator;
	
	private static Logger logger = LoggerFactory.getLogger(Factory.class);

	/*
	 * generator создает документ
	 */
	public void createDocument(DocumentTypes type) {
		this.generator = type.getGenerator();
		try {
			this.generator.createDocument();
		} catch (DocumentExistsException e) {
			logger.info(e.getMessage());
		}
	}
}