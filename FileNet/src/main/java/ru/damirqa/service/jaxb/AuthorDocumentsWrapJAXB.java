package ru.damirqa.service.jaxb;

import ru.damirqa.model.documents.Document;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс описывает обвертку для документов для автора
 */
@XmlRootElement(name = "employee")
public class AuthorDocumentsWrapJAXB {
	
	@XmlElement(name = "document")
	private SortedSet<Document> authorDocuments = new TreeSet<Document>();
	
	public void setAuthorDocuments(SortedSet<Document> sortedSet) {
		 this.authorDocuments = sortedSet;
	}
	
}