package ru.damirqa.factory;

import java.util.concurrent.ThreadLocalRandom;

import ru.damirqa.model.documents.Document;
import ru.damirqa.model.documents.Outgoing;
import ru.damirqa.storage.Employees;

/*
 * Генератор исходящих документов
 */
public class OutgoingGenerator extends Generator{
	
	/**
	 * Создаем документ
	 */
	protected Document create(int registrationNumber) {
		return new Outgoing(registrationNumber, generateDate(), 
				Employees.list.get(ThreadLocalRandom.current().nextInt(Employees.list.size())));
		
	}
}
