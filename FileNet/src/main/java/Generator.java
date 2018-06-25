import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Класс Генератор для генерации документов
 */
public abstract class Generator {
	
	/*
	 * Массивы для рандомго заполнения документов
	 */
	
	public static final List<String> name = Arrays.asList("Внутренний документ", "Архивное дело", 
			"Входящий документ", "Поступивший документ", "Исходящий документ", "Заявление", "Протокол", 
			"Учредительный договор", "Устав предприятия", "Свидетельство");

	public static final List<String> author = Arrays.asList("Антон Силуанов", "Константин Чуйченко", "Максим Акимов", "Юрий Борисов", 
			"Татьяна Голикова", "Ольга Голодец", "Алексей Гордеев", "Дмитрий Козак", "Виталий Мутко", "Юрий Трутнев");

	/*
	 * Метод создает документ и выбрасывает исключение если документ уже создан
	 */
	public Document manufactureDocument() throws DocumentExistsException {
		
		int registrationNumber = ThreadLocalRandom.current().nextInt(1000);
		
		if (hasRegistrationNumber(registrationNumber)) {
			throw new DocumentExistsException("Документ №" + registrationNumber + "уже существует");
		}
		else {
			Document document = create(registrationNumber);
			Repository.STORAGE.add(document);
			return document;
		}
	};
	
	/*
	 * Метод создает конкретный тип документа в зависимости от типа Генератора
	 */
	protected abstract Document create(int registrationNumber);
	
	
	/*
	 * Проверяем существует ли регистрационный номер
	 */
	public boolean hasRegistrationNumber(int registrationNumber) {
		for (Document incoming : Repository.STORAGE) {
			if (incoming.getRegistrationNumber() == registrationNumber) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Создаем рандомную дату
	 */
	public Date generateDate() {
		
		int year = ThreadLocalRandom.current().nextInt(110, 118);
		int month = ThreadLocalRandom.current().nextInt(0, 11);		
		int date = 0;
		
		if (month % 2 == 0) {
			date = ThreadLocalRandom.current().nextInt(1, 31);
		}
		else {
			if (month == 1) {
				if (year % 4 == 0) {
					date = ThreadLocalRandom.current().nextInt(1, 29);
				}
				else {
					date = ThreadLocalRandom.current().nextInt(1, 28);
				}
			}
			else {
				date = ThreadLocalRandom.current().nextInt(1, 30);
			}	
		}
		return new Date(year, month, date);
	}
}
