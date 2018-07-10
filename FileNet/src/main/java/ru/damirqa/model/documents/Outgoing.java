package ru.damirqa.model.documents;

import java.util.Date;

import ru.damirqa.model.staff.Person;

/**
 * Класс Исходящий документ
 */
public class Outgoing extends Document{
	
	private String sender; // Отправитель
	private String deliverymethod; // Способ доставки
	
	public Outgoing(int registrationNumber, Date dateRegistration, Person author) {
		
		setCounter();
		setId();
		
		setRegistrationNumber(registrationNumber);
		setDateRegistration(dateRegistration);
		setAuthor(author);
	}
	
	@Override
	public String toString() {
		return "Исходящий №" + getRegistrationNumber() + " от " + getDateRegistration() + ".";
	}

	public String getSender() {
		return sender;
	}

	public void setAddresser(String sender) {
		this.sender = sender;
	}

	public String getDeliverymethod() {
		return deliverymethod;
	}

	public void setDeliverymethod(String deliverymethod) {
		this.deliverymethod = deliverymethod;
	}
}
