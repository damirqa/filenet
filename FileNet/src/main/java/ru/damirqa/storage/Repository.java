package ru.damirqa.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.damirqa.model.Document;
import ru.damirqa.factory.Generator;

import java.util.SortedSet;
import java.util.TreeSet;

public class Repository {

	private static Logger logger = LoggerFactory.getLogger(Repository.class);
	
	public static SortedSet<Document> STORAGE = new TreeSet<Document>();
	
	/*
	 * Получаем список авторов с документами
	 */
	public static SortedSet<String> getAuthorsWithDocuments() {
		
		SortedSet<String> authorWithDocument = new TreeSet<String>();
		
		for (String author : Generator.author) {
			for (Document document : STORAGE) {
				if (author.equals(document.getAuthor())) {
					authorWithDocument.add(author);
				}
			}
		}
		return authorWithDocument;	
	}
	
	/*
	 * Выводим отчет
	 */  
	public static void printReport() {
		
		SortedSet<String> authors = getAuthorsWithDocuments();
		
		if (authors.isEmpty()) {
			logger.info("Документы не созданы");
		}
		else {
			for (String author : authors) {
				logger.info(author, ":");
				for (Document document : STORAGE) {
					if (author.equals(document.getAuthor())) {
						logger.info("\t" + document);
					}
				}
			}
		}
	}
}
