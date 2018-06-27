package ru.damirqa.factory;

import ru.damirqa.model.Document;
import ru.damirqa.model.Outgoing;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Генератор исходящих документов
 */
public class OutgoingGenerator extends Generator{
	
	/*
	 * Создаем документ
	 */
	protected Document create(int registrationNumber) {
		return new Outgoing(registrationNumber, generateDate(), author.get(ThreadLocalRandom.current().nextInt(9)));
		
	}
}
