package ru.damirqa.model.staff;

public class Organization extends Staff{

	private String fullName; // Полное наименование
	private String shortName; // Краткое наименование
	private String chief; // Руководитель
	private String contactPhoneNumbers; // Контактные телефоны
	
	@Override
	public String toString() {
		return "Организация - " + this.fullName + ". Руководитель - " + this.chief;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
	public String getContactPhoneNumbers() {
		return contactPhoneNumbers;
	}
	public void setContactPhoneNumbers(String contactPhoneNumbers) {
		this.contactPhoneNumbers = contactPhoneNumbers;
	}
}
