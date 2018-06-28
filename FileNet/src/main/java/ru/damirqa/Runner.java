package ru.damirqa;

import ru.damirqa.factory.DocumentTypes;
import ru.damirqa.factory.Factory;
import ru.damirqa.service.EmployeesWrapJAXB;
import ru.damirqa.storage.Employees;
import ru.damirqa.storage.Repository;
import ru.damirqa.utils.ReportJSON;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Runner {

	public static void main(String[] args) {
		
		Employees.setListOfEmployees(new File("C:\\Users\\kacer\\Desktop\\emp.xml"), EmployeesWrapJAXB.class);
				
		Factory factory = new Factory();
		
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(10); i++) {
			factory.createDocument(DocumentTypes.values()[ThreadLocalRandom.current().nextInt(0, DocumentTypes.values().length)]);
		}
		Repository.printReport();
		
		ReportJSON.convertReportToJSON(Repository.report);
	}
}