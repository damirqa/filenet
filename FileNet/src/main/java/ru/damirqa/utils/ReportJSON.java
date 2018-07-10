package ru.damirqa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import ru.damirqa.model.documents.Document;
import ru.damirqa.model.staff.Person;
import ru.damirqa.storage.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Map.Entry;

/**
 * Класс описывает работу перевода данных в json-объекты
 */
public class ReportJSON {

	private static Logger logger = LoggerFactory.getLogger(ReportJSON.class);
	
	public static void convertReportToJSON(SortedMap<Person, SortedSet<Document>> report) {
		
		Gson gson = new Gson();
		
		if (Repository.report.size() != 0) {
			for (Entry<Person, SortedSet<Document>> link : report.entrySet()) {
				try (Writer writer = new FileWriter(ReportJSON.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() 
						+ link.getKey() + ".json")) {
					String json = gson.toJson(link.getValue());
					writer.write(json);
				} catch (JsonIOException | IOException | URISyntaxException e) {
					logger.info(e.getMessage());
				}
			}
		}		
	}
}
