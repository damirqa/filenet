package ru.damirqa.storage;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.damirqa.model.staff.Person;

@XmlRootElement(name = "Employees")
public class Employees {

    @XmlElement(name = "Person")
	public static ArrayList<Person> listOfEmployees = new ArrayList<Person>();
	
    @Override
    public String toString() {
    	return "Персонал";
    }
}
