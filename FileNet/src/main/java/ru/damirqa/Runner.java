package ru.damirqa;

import ru.damirqa.factory.Factory;
import ru.damirqa.factory.IncomingGenerator;
import ru.damirqa.factory.OutgoingGenerator;
import ru.damirqa.factory.TaskGenerator;
import ru.damirqa.storage.Repository;

public class Runner {

	public static void main(String[] args) {

		Factory incomingFactory = new Factory(new IncomingGenerator());
		incomingFactory.createDocument();
		
		Factory outgoingFactory = new Factory(new OutgoingGenerator());
		outgoingFactory.createDocument();

		Factory taskFactory = new Factory(new TaskGenerator());
		taskFactory.createDocument();
		
		Repository.printReport();
	}
}
