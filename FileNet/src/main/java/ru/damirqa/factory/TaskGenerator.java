package ru.damirqa.factory;

import java.util.concurrent.ThreadLocalRandom;

import ru.damirqa.model.documents.Document;
import ru.damirqa.model.documents.Task;
import ru.damirqa.storage.Employees;

public class TaskGenerator extends Generator{

	/*
	 * Создаем документ
	 */
	@Override
	protected Document create(int registrationNumber) {
		return new Task(registrationNumber, generateDate(), 
				Employees.listOfEmployees.get(ThreadLocalRandom.current().nextInt(Employees.listOfEmployees.size())));
	}
}
