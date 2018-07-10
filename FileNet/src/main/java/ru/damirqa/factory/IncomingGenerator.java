package ru.damirqa.factory;

import java.util.concurrent.ThreadLocalRandom;

import ru.damirqa.model.documents.Document;
import ru.damirqa.model.documents.Incoming;
import ru.damirqa.storage.Employees;

/**
 * Генератор входящих документов
 */
public class IncomingGenerator extends Generator{
	
	/**
	 * Создаем документ
	 */
	protected Document create(int registrationNumber) {
		return new Incoming(registrationNumber, generateDate(), 
				Employees.list.get(ThreadLocalRandom.current().nextInt(Employees.list.size())));
	}
}
