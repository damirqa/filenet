import java.util.concurrent.ThreadLocalRandom;

/*
 * Генератор исходящих документов
 */
public class OutgoingGenerator extends Generator{
	
	private String[] deliverymethod = {"Курьерская доставка", "Доставка почтовой службой", 
			"Доставка транспортными компаниями"};

	/*
	 * Метод создает "Исходящий документ" и сохрянает в хранилище.
	 * Если документ уже существует, то выбрасывается исключение
	 */
	public Document manufactureDocument() throws DocumentExistsException{
		
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
		return new Outgoing(name[ThreadLocalRandom.current().nextInt(9)], null,
				ThreadLocalRandom.current().nextInt(1000), setDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], addresser[ThreadLocalRandom.current().nextInt(9)], 
				deliverymethod[ThreadLocalRandom.current().nextInt(2)]);
	}
}
