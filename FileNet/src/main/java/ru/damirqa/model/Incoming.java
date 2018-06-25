package ru.damirqa.model;

import java.util.Date;

/*
 * Класс Входящий документ
 */
public class Incoming extends Document{
	
	private String sender; // Отправитель
	private String addressee; // Адресат
	private int outgoingNumber; // Исходящий номер
	private Date outgoingRegistrationDate; // Исходящая дата регистрации
	
	public Incoming(String name, int registrationNumber, Date dateRegistration, String author) {
		
		setCounter();
		setId();
		
		setName(name);
		setRegistrationNumber(registrationNumber);
		setDateRegistration(dateRegistration);
		setAuthor(author);
	}
	
	@Override
	public String toString() {
		return "Входящий №" + getRegistrationNumber() + " от " + getDateRegistration() + ". " + getName() + "";
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
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
