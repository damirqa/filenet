import java.util.concurrent.ThreadLocalRandom;

public class IncomingBlacksmith extends Blacksmith{
	
	/*
	 * Метод создает "Входящий документ" и сохрянает в хранилище.
	 * Если документ уже существует, то выбрасывается исключение
	 */
	public Document manufactureDocument() throws DocumentExistsException {
		
		int regNumber = ThreadLocalRandom.current().nextInt(1000);
		
		if (hasRegistrationNumber(regNumber)) {
			throw new DocumentExistsException("Документ уже существует");
		}
		else {
			Document document = create(regNumber);
			Repository.STORAGE.add(document);
			return document;
		}
	}
	
	/*
	 * Создаем документ
	 */
	protected Document create(int regNumber) {
		return new Incoming(name[ThreadLocalRandom.current().nextInt(9)], null, 
				regNumber, setDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], 
				addresser[ThreadLocalRandom.current().nextInt(9)], addressee[ThreadLocalRandom.current().nextInt(9)], 
				ThreadLocalRandom.current().nextInt(1000), setDate());
	}
}
