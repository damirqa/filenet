import java.util.Date;

// Класс "Входящий документ"

public class Incoming extends Document{
	
	// Что с типами

	private String addresser; // Отправитель
	private String addressee; // Адресат
	private int outgoingNumber; // Исходящий номер
	private Date outgoingRegistrationDate; // Исходящая дата регистрации
	
	
	@Override
	public String toString() {
		return "Входящий документ [Отправитель=" + addresser + ", Получатель=" + addressee + ", Исходящий номер=" + outgoingNumber
				+ ", Исходящая дата регистрации=" + outgoingRegistrationDate + ", ID=" + id + ", Название=" + name
				+ ", Регистрационный номер=" + registrationNumber + ", Автор=" + author + "]";
	}
	
	
}
