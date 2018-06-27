package ru.damirqa.model.staffs;

public class Person extends Staff implements Comparable<Person>{

	private String firstName; // Имя
	private String middleName; // Отчество
	private String lastName; // Фамилия
	private String position; // Должность
		
	public int compareTo(Person person) {
		
		int result = this.firstName.compareTo(person.getFirstName());
		if (result != 0) {
			return result;
		}
		
		result = this.middleName.compareTo(person.getMiddleName());
		if (result != 0) {
			return result;
		}
		
		result = this.lastName.compareTo(person.getLastName());
		if (result != 0) {
			return result;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "" + this.firstName + " " + this.middleName + " " + this.lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
