package ru.damirqa.controllers;

import com.google.gson.Gson;

import ru.damirqa.service.EmployeesWrapJAXB;
import ru.damirqa.storage.Employees;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ecm")
public class EmployeesController {

	@Path("/employees")
	@GET
	@Produces("application/json")
	public String getEmployeesJSON() {
		if (Employees.list.isEmpty()) {
			Employees.setListOfEmployees(new File("C:\\Users\\kacer\\Desktop\\emp.xml"), EmployeesWrapJAXB.class);
		}
		return new Gson().toJson(Employees.list);
	}
}
