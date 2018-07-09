 package ru.damirqa;

import ru.damirqa.factory.DocumentTypes;
import ru.damirqa.factory.Factory;
import ru.damirqa.service.jaxb.EmployeesWrapJAXB;
import ru.damirqa.storage.Employees;
import ru.damirqa.storage.Repository;
import ru.damirqa.utils.ReportJSON;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Класс описывает запуск консольного приложения
 */
public class Runner {

	public static void main(String[] args) {
		
		/**
		 * Получаем список персон из emp.xml и сохраняем в список Employees.list
		 */
		Employees.setListOfEmployees(new File(Thread.currentThread().getContextClassLoader().getResource("emp.xml").getFile()), EmployeesWrapJAXB.class);
				
		/**
		 * Создаем фабрику
		 */
		Factory factory = new Factory();
		
		/**
		 * Генерируем рандомное количество документов
		 */
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(10); i++) {
			factory.createDocument(DocumentTypes.values()[ThreadLocalRandom.current().nextInt(0, DocumentTypes.values().length)]);
		}
		
		/**
		 * Выводим отчет
		 */
		Repository.printReport();
		
		/**
		 * Конвертируем отчет в JSON - объект
		 */
		ReportJSON.convertReportToJSON(Repository.report);
	}
}