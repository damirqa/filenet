import java.util.concurrent.ThreadLocalRandom;

/*
 * Генератор входящих документов
 */
public class IncomingGenerator extends Generator{
	
	/*
	 * Метод создает "Входящий документ" и сохрянает в хранилище.
	 * Если документ уже существует, то выбрасывается исключение
	 */
	public Document manufactureDocument() throws DocumentExistsException {
		
		int registrationNumber = ThreadLocalRandom.current().nextInt(1000);
		
		if (hasRegistrationNumber(registrationNumber)) {
			throw new DocumentExistsException("Документ уже существует");
		}
		else {
			Document document = create(registrationNumber);
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
