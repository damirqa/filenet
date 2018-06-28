package ru.damirqa;

import ru.damirqa.factory.DocumentTypes;
import ru.damirqa.factory.Factory;
import ru.damirqa.storage.Employees;
import ru.damirqa.storage.Repository;
import ru.damirqa.utils.ParserJAXB;
import ru.damirqa.utils.ReportJSON;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.JAXBException;

public class Runner {

	public static void main(String[] args) {
		
		
		try {
			ParserJAXB.unmarshalling(new File("C:\\Users\\kacer\\Desktop\\emp.xml"), Employees.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		Factory factory = new Factory();
		
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(10); i++) {
			factory.createDocument(DocumentTypes.values()[ThreadLocalRandom.current().nextInt(0, DocumentTypes.values().length)]);
		}
		Repository.printReport();
		
		ReportJSON.convertReportToJSON(Repository.report);
	}
}