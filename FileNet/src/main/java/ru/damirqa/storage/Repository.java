package ru.damirqa.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.damirqa.model.documents.Document;
import ru.damirqa.model.staff.Person;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Repository {

	private static Logger logger = LoggerFactory.getLogger(Repository.class);
	
	public static SortedSet<Document> STORAGE = new TreeSet<Document>();
	
	public static SortedMap<Person, SortedSet<Document>> report = new TreeMap<Person, SortedSet<Document>>();

	
	/*
	 * Формируем отчет
	 */
	private static void formReport() {
				
		for (Document document : STORAGE) {
			if (!report.containsKey(document.getAuthor())) {
				report.put(document.getAuthor(), new TreeSet<Document>());
			}
			report.get(document.getAuthor()).add(document);
		}
	}
	
	/*
	 * Выводим отчет
	 */  
	public static void printReport() {
		
		formReport();
		
		if (report.size() != 0) {
			for (Entry<Person, SortedSet<Document>> link : report.entrySet()) {
				logger.info(link.getKey() + link.getValue().toString().replaceAll("\\[|,\\s", "\n\t").replaceAll("\\]", ""));
			}
		}
		else {
			logger.info("Документы не созданы");
		}
	}
}
