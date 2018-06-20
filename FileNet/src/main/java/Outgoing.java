import java.util.Date;

/*
 * Класс Исходящий документ
 */
public class Outgoing extends Document{
	
	private String addresser; // Адресат
	private String deliverymethod; // Способ доставки
	
	public Outgoing(String name, String text, int registrationNumber, Date dateRegistration, String author,
			String addresser, String deliverymethod) {
		
		setCounter();
		setId();
		
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
		return "Исходящий №" + getRegistrationNumber() + " от " + getDateRegistration() + ". " + getName() + "";
	}
}
