import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

// Фабрика
public class Factory {
	
	private String[] name = {"Внутренний документ", "Архивное дело", "Входящий документ", "Поступивший документ", "Исходящий документ",
			"Заявление", "Протокол", "Учредительный договор", "Устав предприятия", "Свидетельство"};
	
	private String[] author = {"Антон Силуанов", "Константин Чуйченко", "Максим Акимов", "Юрий Борисов", "Татьяна Голикова", 
			"Ольга Голодец", "Алексей Гордеев", "Дмитрий Козак", "Виталий Мутко", "Юрий Трутнев"};
	
	private String[] addresser = {"Тимур Гришин", "Артём Рожков", "Виктор Рогов", "Данила Степанов", "Ярослав Носков", 
			"Анатолий Жданов", "Егор Родионов", "Алексей Фокин", "Ростислав Кудрявцев", "Игорь Кириллов"};
	
	private String[] addressee = {"Юрий Киселёв", "Данила Сафонов", "Тимур Кузнецов", "Григорий Носов", "Эдуард Харитонов",
			"Никита Гуляев", "Пётр Большаков", "Олег Капустин", "Анатолий Силин", "Валерий Богданов"};
	
	private String[] deliverymethod = {"Курьерская доставка", "Доставка почтовой службой", "Доставка транспортными компаниями"};
	
	Repository repo;
	
	public Factory() {
		this.repo = new Repository();
	}
	
	
	public void make(DocumentType type) {
		
		switch(type) {
		case INCOMING:
			makeIncoming();
			break;
		case OUTGOING:
			makeOutgoing();
			break;
		case TASK:
			makeTask();
			break;
		}
		
	}
	
	public void makeIncoming() {
		Incoming incoming = new Incoming(name[ThreadLocalRandom.current().nextInt(9)], null, ThreadLocalRandom.current().nextInt(10000),
				setDate(), author[ThreadLocalRandom.current().nextInt(9)],
				addresser[ThreadLocalRandom.current().nextInt(9)], addressee[ThreadLocalRandom.current().nextInt(9)], 
				ThreadLocalRandom.current().nextInt(10000), setDate());
		
		this.repo.add(incoming);
	}
	
	public void makeOutgoing() {
		Outgoing outgoing = new Outgoing(name[ThreadLocalRandom.current().nextInt(9)], null, ThreadLocalRandom.current().nextInt(10000),
				setDate(), author[ThreadLocalRandom.current().nextInt(9)],
				addresser[ThreadLocalRandom.current().nextInt(9)], deliverymethod[ThreadLocalRandom.current().nextInt(2)]);
		
		this.repo.add(outgoing);
	}
	
	public void makeTask() {
		Task task = new Task(name[ThreadLocalRandom.current().nextInt(9)], null, ThreadLocalRandom.current().nextInt(10000),
				setDate(), author[ThreadLocalRandom.current().nextInt(9)], 
				setDate(), ThreadLocalRandom.current().nextInt(10), author[ThreadLocalRandom.current().nextInt(9)],
				null, null);
		this.repo.add(task);
	}
	
	public Date setDate() {
		
		int year = ThreadLocalRandom.current().nextInt(110, 118);
		int month = ThreadLocalRandom.current().nextInt(0, 11);		
		int date = ThreadLocalRandom.current().nextInt(1, 30);
		
		return new Date(year, month, date);
	}
	
	public void info() {
		this.repo.info();
	}
}
