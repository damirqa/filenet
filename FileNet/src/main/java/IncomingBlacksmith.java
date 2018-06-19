import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class IncomingBlacksmith implements Blacksmith{
	
	/*
	 * Метод создает "Входящий документ" и сохрянает в "табличке".
	 * Если документ уже существует, то выбрасывается исключение
	 */
	public Document manufactureDocument() throws DocumentExistsException {
		
		int regNumber = ThreadLocalRandom.current().nextInt(1000);
		
		if (hasRegistrationNumber(regNumber)) {
			throw new DocumentExistsException("Документ уже существует");
		}
		else {
			Incoming incoming = create(regNumber);
			Repository.incomingRepository.add(incoming);
			
			System.out.println(Repository.incomingRepository.get(0));
			return incoming;
		}
	}
	
	/*
	 * Проверяем существует ли регистрационный номер
	 */
	private boolean hasRegistrationNumber(int regNumber) {
		for (Incoming incoming : Repository.incomingRepository) {
			if (incoming.getRegistrationNumber() == regNumber) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Создаем документ
	 */
	public Incoming create(int regNumber) {
		return new Incoming(name[ThreadLocalRandom.current().nextInt(9)], null, 
				regNumber, setDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], 
				addresser[ThreadLocalRandom.current().nextInt(9)], addressee[ThreadLocalRandom.current().nextInt(9)], 
				ThreadLocalRandom.current().nextInt(1000), setDate());
	}
	
	/*
	 * Создаем рандомную дату
	 */
	public Date setDate() {
	
		int year = ThreadLocalRandom.current().nextInt(110, 118);
		int month = ThreadLocalRandom.current().nextInt(0, 11);		
		int date = ThreadLocalRandom.current().nextInt(1, 30);
		
		return new Date(year, month, date);
	}
}
