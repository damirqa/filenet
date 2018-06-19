import java.util.Date;

// Класс "Входящий документ"

public class Incoming extends Document{
	
	private String addresser; // Отправитель
	private String addressee; // Адресат
	private int outgoingNumber; // Исходящий номер
	private Date outgoingRegistrationDate; // Исходящая дата регистрации
	
	public Incoming(String name, String text, int registrationNumber, Date dateRegistration, String author,
			String addresser, String addressee, int outgoingNumber, Date outgoingRegistrationDate) {
		
		setCounter();
		setId();
		
		setName(name);
		setText(text);
		setRegistrationNumber(registrationNumber);
		setDateRegistration(dateRegistration);
		setAuthor(author);
		
		this.addresser = addresser;
		this.addressee = addressee;
		this.outgoingNumber = outgoingNumber;
		this.outgoingRegistrationDate = outgoingRegistrationDate;
	}
	
	@Override
	public String toString() {
		return "Входящий документ [Отправитель=" + addresser + ", Получатель=" + addressee + ", Исходящий номер=" + outgoingNumber
				+ ", Исходящая дата регистрации=" + outgoingRegistrationDate + ", ID=" + getId() + ", Название=" + getName()
				+ ", Регистрационный номер=" + getRegistrationNumber() + ", Автор=" + getAuthor() + "]";
	}

	public String getAddresser() {
		return addresser;
	}

	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public int getOutgoingNumber() {
		return outgoingNumber;
	}

	public void setOutgoingNumber(int outgoingNumber) {
		this.outgoingNumber = outgoingNumber;
	}

	public Date getOutgoingRegistrationDate() {
		return outgoingRegistrationDate;
	}

	public void setOutgoingRegistrationDate(Date outgoingRegistrationDate) {
		this.outgoingRegistrationDate = outgoingRegistrationDate;
	}
	
	
	
}
