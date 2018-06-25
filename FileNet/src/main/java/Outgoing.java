import java.util.Date;

/*
 * Класс Исходящий документ
 */
public class Outgoing extends Document{
	
	private String addresser; // Адресат
	private String deliverymethod; // Способ доставки
	
	public Outgoing(String name, int registrationNumber, Date dateRegistration, String author) {
		
		setCounter();
		setId();
		
		setName(name);
		setRegistrationNumber(registrationNumber);
		setDateRegistration(dateRegistration);
		setAuthor(author);
	}
	
	@Override
	public String toString() {
		return "Исходящий №" + getRegistrationNumber() + " от " + getDateRegistration() + ". " + getName() + "";
	}

	public String getAddresser() {
		return addresser;
	}

	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}

	public String getDeliverymethod() {
		return deliverymethod;
	}

	public void setDeliverymethod(String deliverymethod) {
		this.deliverymethod = deliverymethod;
	}
}
