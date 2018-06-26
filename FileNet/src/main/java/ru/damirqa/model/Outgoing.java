package ru.damirqa.model;

import java.util.Date;

/*
 * Класс Исходящий документ
 */
public class Outgoing extends Document{
	
	private String sender; // Отправитель
	private String deliverymethod; // Способ доставки
	
	public Outgoing(int registrationNumber, Date dateRegistration, String author) {
		
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
