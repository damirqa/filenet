import java.util.Date;

// Класс "Исходящий документ" 

public class Outgoing extends Document{
	
	// Что с типами?
	
	private String addresser; // Адресат
	private String deliverymethod; // Способ доставки
	
	public Outgoing(String name, String text, int registrationNumber, Date dateRegistration, String author,
			String addresser, String deliverymethod) {
		
		setName(name);
		setText(text);
		setRegistrationNumber(registrationNumber);
		setDateRegistration(dateRegistration);
		setAuthor(author);
		
		this.addresser = addresser;
		this.deliverymethod = deliverymethod;
		
	}
	
	@Override
	public String toString() {
		return "Исходящий документ [Отправитель=" + addresser + ", Способ доставки=" + deliverymethod + ", ID=" + getId() + ", Название="
				+ getName() + ", Регистрационный номер=" + getRegistrationNumber() + ", Автор=" + getAuthor() + "]";
	}
}
