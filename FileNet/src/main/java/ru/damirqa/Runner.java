package ru.damirqa;

import ru.damirqa.factory.DocumentTypes;
import ru.damirqa.factory.Factory;
import ru.damirqa.storage.Repository;

import java.util.concurrent.ThreadLocalRandom;

public class Runner {

	public static void main(String[] args) {

		Factory factory = new Factory();
		
		int count = ThreadLocalRandom.current().nextInt(10);
		
		for (int i = 0; i < count; i++) {
			int type = ThreadLocalRandom.current().nextInt(0,3) * 10 / 3;
			switch(type) {
				case 0: factory.createDocument(DocumentTypes.INCOMING);
				break;
				case 3: factory.createDocument(DocumentTypes.OUTGOING);
				break;
				case 6: factory.createDocument(DocumentTypes.TASK);
				break;
			} 
		}
		Repository.printReport();
	}
}
