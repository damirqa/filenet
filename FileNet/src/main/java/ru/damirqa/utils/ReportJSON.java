package ru.damirqa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import ru.damirqa.model.documents.Document;
import ru.damirqa.model.staffs.Person;
import ru.damirqa.storage.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.SortedSet;
import java.util.Map.Entry;

public class ReportJSON {

	private static Logger logger = LoggerFactory.getLogger(ReportJSON.class);
	
	
	public static void convertReportToJSON() {
		
		Gson gson = new Gson();
		Writer writer;
		
		if (Repository.report.size() != 0) {
			for (Entry<Person, SortedSet<Document>> link : Repository.report.entrySet()) {
				try {
					writer = new FileWriter("C:\\Users\\kacer\\Desktop\\" + link.getKey() + ".json");
					String json = gson.toJson(link.getValue());
					writer.write(json);
					writer.close();
				} catch (JsonIOException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
