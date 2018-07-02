package ru.damirqa.controllers;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import ru.damirqa.service.EmployeesWrapJAXB;
import ru.damirqa.storage.Employees;

@Path("/ecm")
public class EmployeesController {

	@Path("/employees")
	@GET
	@Produces("application/json")
	public String getEmployeesJSON() {
		
		Employees.setListOfEmployees(new File("C:\\Users\\kacer\\Desktop\\emp.xml"), EmployeesWrapJAXB.class);
		
		Gson gson = new Gson();
		String json = gson.toJson(Employees.listOfEmployees);
		JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
		return json;
	}
}
