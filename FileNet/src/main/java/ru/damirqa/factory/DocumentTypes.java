package ru.damirqa.factory;

/**
 * Перечень типов документов
 */
public enum DocumentTypes {

	INCOMING(new IncomingGenerator()), OUTGOING(new OutgoingGenerator()), TASK(new TaskGenerator());
	
	private final Generator generator;	
	
	DocumentTypes(Generator generator) {
		this.generator = generator;
	}

	public Generator getGenerator() {
		return generator;
	}
}
