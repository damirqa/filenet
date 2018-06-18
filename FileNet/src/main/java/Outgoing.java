// Класс "Исходящий документ" 

public class Outgoing extends Document{
	
	// Что с типами?
	
	private String addresser; // Адресат
	private String deliverymethod; // Способ доставки
	
	public Outgoing(String str) {
		super();
		this.addresser = str;
	}
	
	
	@Override
	public String toString() {
		return "Исходящий документ [Отправитель=" + addresser + ", Способ доставки=" + deliverymethod + ", ID=" + id + ", Название="
				+ name + ", Регистрационный номер=" + registrationNumber + ", Автор=" + author + "]";
	}
	
	
	
}
