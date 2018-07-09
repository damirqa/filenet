package ru.damirqa.controllers;

import com.google.gson.Gson;

import ru.damirqa.model.documents.Document;
import ru.damirqa.model.staff.Person;
import ru.damirqa.service.jaxb.AuthorDocumentsWrapJAXB;
import ru.damirqa.storage.Employees;
import ru.damirqa.storage.Repository;
import ru.damirqa.utils.ParserJAXB;

import java.util.SortedSet;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Класс описывает какие данные будут возвращены
 */
@Path("/ecm")
public class EmployeesController {

	/**
	 * Метод возвращает список персон в json-объекте
	 */
	@Path("/employees")
	@GET
	@Produces("application/json")
	public String getEmployeesJSON() {
		return new Gson().toJson(Employees.list);
	}
	
	/**
	 * Метод воззвращает список документов автора
	 */
	@Path("/employees/{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getListAuthorDocuments(@PathParam("id") int id) {
	
		Person person = Employees.list.get(id);
		
		String output = "Person has no documents";
		
		AuthorDocumentsWrapJAXB authorDocuments = new AuthorDocumentsWrapJAXB();
		
		if (person != null) {
			for (Entry<Person, SortedSet<Document>> link : Repository.report.entrySet()) {
				authorDocuments.setAuthorDocuments(link.getValue());
				if (link.getKey().getId() == id) output = ParserJAXB.marshal(authorDocuments, AuthorDocumentsWrapJAXB.class);
			}
			return output;
		}
		else {
			return "Person does not exist";
		}
	}
}