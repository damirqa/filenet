package ru.damirqa;

import ru.damirqa.factory.DocumentTypes;
import ru.damirqa.factory.Factory;
import ru.damirqa.storage.Repository;

import java.util.concurrent.ThreadLocalRandom;

public class Runner {

	public static void main(String[] args) {

		Factory factory = new Factory();
		
		for (int i = 0; i < ThreadLocalRandom.current().nextInt(10); i++) {
			factory.createDocument(DocumentTypes.values()[ThreadLocalRandom.current().nextInt(0, DocumentTypes.values().length)]);
		}
		Repository.printReport();
	}
}
