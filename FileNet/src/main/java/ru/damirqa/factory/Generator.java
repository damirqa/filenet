package ru.damirqa.factory;

import ru.damirqa.exceptions.DocumentExistsException;
import ru.damirqa.model.documents.Document;
import ru.damirqa.storage.Repository;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс Генератор для генерации документов
 */
public abstract class Generator {
	
	/**
	 * Метод создает документ и выбрасывает исключение если документ уже создан
	 */
	public void createDocument() throws DocumentExistsException {
		
		int registrationNumber = ThreadLocalRandom.current().nextInt(1000);
		
		if (hasRegistrationNumber(registrationNumber)) {
			throw new DocumentExistsException("Документ №" + registrationNumber + " уже существует");
		}
		else {
			Document document = create(registrationNumber);
			Repository.STORAGE.add(document);
		}
	};
	
	/**
	 * Метод создает документ
	 */
	protected abstract Document create(int registrationNumber);
	
	
	/**
	 * Проверяем существует ли регистрационный номер
	 */
	public boolean hasRegistrationNumber(int registrationNumber) {
		for (Document incoming : Repository.STORAGE) {
			if (incoming.getRegistrationNumber() == registrationNumber) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Создаем рандомную дату
	 */
	public Date generateDate() {
		return new Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextLong(1000*60*60*24*1000));
	}
}
