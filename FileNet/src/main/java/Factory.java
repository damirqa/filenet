import java.util.concurrent.ThreadLocalRandom;

// Фабрика
public class Factory {
	
	private String[] name = {"Внутренний документ", "Архивное дело", "Входящий документ", "Поступивший документ", "Исходящий документ",
			"Заявление", "Протокол", "Учредительный договор", "Устав предприятия", "Свидетельство"};
	
	private String[] author = {"Антон Силуанов", "Константин Чуйченко", "Максим Акимов", "Юрий Борисов", "Татьяна Голикова", 
			"Ольга Голодец", "Алексей Гордеев", "Дмитрий Козак", "Виталий Мутко", "Юрий Трутнев"};
	
	private String[] addresser = {};
	
	private String[] addressee = {};
	
	Repository repo;
	
	public Factory() {
		this.repo = new Repository();
	}
	
	
	public void make(DocumentType type) {
		
		switch(type) {
		case INCOMING:
			//makeIncoming();
			break;
		case OUTGOING:
			makeOutgoing();
			break;
		case TASK:
			makeTask();
			break;
		}
		
	}
	
//	public void makeIncoming() {
//		
//		Incoming incoming = new Incoming(name[ThreadLocalRandom.current().nextInt(10)], null, ThreadLocalRandom.current().nextInt(10000),
//				dateRegistration, author,
//				addresser, addressee, outgoingNumber, outgoingRegistrationDate)
//	}
	
	public void makeOutgoing() {}
	
	public void makeTask() {}
	
	public void setDate() {
		
	}
}
