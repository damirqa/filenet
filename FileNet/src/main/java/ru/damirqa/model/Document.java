package ru.damirqa.model;

import java.util.Date;

/*
 * Класс "Документ"
 */
public abstract class Document implements Comparable<Document> {
	
	private static int counter = 0; // Счетчик документов
	private int id = 0; // Идентификатор документа 
	private String name; // Название документа
	private String text; // Текст документа
	private int registrationNumber; // Регистрационный номер документа
	private Date dateRegistration; // Дата регистрации документа
	private String author; // Автор документа

	/*
	 * Метод для сравнения документов по полям dateRegistration и registrationNumber
	 */
	public int compareTo(Document document) {
		
		int result = dateRegistration.compareTo(document.getDateRegistration());		
		if (result != 0) {
			return result;
		}
		
		result = getRegistrationNumber() - document.getRegistrationNumber();
		if (result != 0) {
			return (int) result / Math.abs(result);
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "Документ [ID=" + id + ", Название=" + name + ", Регистрационный номер=" + registrationNumber
				+ ", Дата регистрации=" + dateRegistration + ", Автор=" + author + "]";
	}

	
	public int getCounter() {
		return counter;
	}
	
	/*
	 * Счетчик документов
	 */
	public void setCounter() {
		Document.counter++;
	}
	
	public int getId() {
		return id;
	}

	public void setId() { 
		this.id = Document.counter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
