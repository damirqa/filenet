import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Blacksmith {
	
	public final static String[] name = {"Внутренний документ", "Архивное дело", "Входящий документ", "Поступивший документ", "Исходящий документ",
			"Заявление", "Протокол", "Учредительный договор", "Устав предприятия", "Свидетельство"};
	
	public final static String[] author = {"Антон Силуанов", "Константин Чуйченко", "Максим Акимов", "Юрий Борисов", "Татьяна Голикова", 
			"Ольга Голодец", "Алексей Гордеев", "Дмитрий Козак", "Виталий Мутко", "Юрий Трутнев"};
	
	public static String[] addresser = {"Тимур Гришин", "Артём Рожков", "Виктор Рогов", "Данила Степанов", "Ярослав Носков", 
			"Анатолий Жданов", "Егор Родионов", "Алексей Фокин", "Ростислав Кудрявцев", "Игорь Кириллов"};
	
	public static String[] addressee = {"Юрий Киселёв", "Данила Сафонов", "Тимур Кузнецов", "Григорий Носов", "Эдуард Харитонов",
			"Никита Гуляев", "Пётр Большаков", "Олег Капустин", "Анатолий Силин", "Валерий Богданов"};

	public abstract Document manufactureDocument() throws DocumentExistsException;
	
	protected abstract Document create(int regNumber);
	
	
	/*
	 * Проверяем существует ли регистрационный номер
	 */
	public boolean hasRegistrationNumber(int regNumber) {
		for (Document incoming : Repository.STORAGE) {
			if (incoming.getRegistrationNumber() == regNumber) {
				return true;
			}
		}
		return false;
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
