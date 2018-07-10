package ru.damirqa.controllers;

import ru.damirqa.factory.DocumentTypes;
import ru.damirqa.factory.Factory;
import ru.damirqa.service.jaxb.EmployeesWrapJAXB;
import ru.damirqa.service.DataBaseService;
import ru.damirqa.storage.Employees;
import ru.damirqa.storage.Repository;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.ApplicationPath;

/**
 * Класс описывает запуск веб-приложения
 */
@ApplicationPath("/app")
public class Application extends javax.ws.rs.core.Application {
	
	public Application() {
		
		/**
		 * Получаем список персон из emp.xml и сохраняем в список Employees.list
		 */
		Employees.setListOfEmployees(new File(Thread.currentThread().getContextClassLoader().getResource("emp.xml").getFile()), EmployeesWrapJAXB.class);
	
		new DataBaseService();
	
		/**
		 * Создаем фабрику
		 */
    Factory factory = new Factory();
		
		/**
		 * Генерируем рандомное количество документов
		 */
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(100); i++) {
			factory.createDocument(DocumentTypes.values()[ThreadLocalRandom.current().nextInt(0, DocumentTypes.values().length)]);
		}
		
		/**
		 * Формируем отчет
		 */
		Repository.formReport();
	}
}