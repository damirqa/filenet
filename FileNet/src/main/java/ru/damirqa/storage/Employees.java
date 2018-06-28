package ru.damirqa.storage;

import ru.damirqa.model.staff.Person;
import ru.damirqa.service.EmployeesWrapJAXB;
import ru.damirqa.utils.ParserJAXB;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employees {
	
	private static Logger logger = LoggerFactory.getLogger(Employees.class);

	public static ArrayList<Person> listOfEmployees = new ArrayList<Person>();
	
	public static void setListOfEmployees(File file, Class<?> objectClass) {

		Object list = null;
		try {
			list = ParserJAXB.unmarshal(file, objectClass);
		} catch (JAXBException e) {
			logger.info(e.getMessage());
		} finally {
			if (list != null) {
				listOfEmployees = EmployeesWrapJAXB.getEmployees();
			}
		}
	}
}
