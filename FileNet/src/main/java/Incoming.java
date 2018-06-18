import java.util.Date;

// Класс "Входящий документ"

public class Incoming extends Document{
	
	// Что с типами

	private String addresser; // адресат
	private String addressee; // получатель
	private int outgoingNumber; // исходящий номер
	private Date outgoingRegistrationDate; // исходяшая дата регистрации
	
	
	public int compareTo(Document o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
