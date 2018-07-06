package ru.damirqa.controllers;

import ru.damirqa.factory.DocumentTypes;
import ru.damirqa.factory.Factory;
import ru.damirqa.service.DataBaseService;
import ru.damirqa.service.EmployeesWrapJAXB;
import ru.damirqa.storage.Employees;
import ru.damirqa.storage.Repository;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/app")
public class Application extends javax.ws.rs.core.Application {
	
	public Application() {
		
		Employees.setListOfEmployees(new File("C:\\Users\\kacer\\Desktop\\emp.xml"), EmployeesWrapJAXB.class);
		
		new DataBaseService();
		
		Factory factory = new Factory();
		
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(100); i++) {
			factory.createDocument(DocumentTypes.values()[ThreadLocalRandom.current().nextInt(0, DocumentTypes.values().length)]);
		}
		
		Repository.formReport();
	}
}