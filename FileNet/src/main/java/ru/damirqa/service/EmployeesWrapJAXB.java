package ru.damirqa.service;

import ru.damirqa.model.staff.Person;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employees")
public class EmployeesWrapJAXB {
	
	@XmlElement(name = "Person")
	private static ArrayList<Person> employees = new ArrayList<Person>();
	
	public static ArrayList<Person> getEmployees() {
		return employees;
	}
}