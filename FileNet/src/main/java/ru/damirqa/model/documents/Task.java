package ru.damirqa.model.documents;

import java.util.Date;

import ru.damirqa.model.staff.Person;

/*
 * Класс Поручение
 */
public class Task  extends Document {

	private Date dateIssue; // Дата выдачи поручения
	private int termExecutionOfInstructions; // Срок исполнения поручения
	private String responsibleExecutor; // Ответственный исполнитель
	private String signOfContentity; // Признак контрольности
	private String orderController; // Контролер поручения
	
	public Task(int registrationNumber, Date dateRegistration, Person author) {
		
		setCounter();
		setId();
		
		setRegistrationNumber(registrationNumber);
		setDateRegistration(dateRegistration);
		setAuthor(author);
	}

	@Override
	public String toString() {
		return "Поручение №" + getRegistrationNumber() + " от " + getDateRegistration() + ".";
	}

	public Date getDateIssue() {
		return dateIssue;
	}

	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}

	public int getTermExecutionOfInstructions() {
		return termExecutionOfInstructions;
	}

	public void setTermExecutionOfInstructions(int termExecutionOfInstructions) {
		this.termExecutionOfInstructions = termExecutionOfInstructions;
	}

	public String getResponsibleExecutor() {
		return responsibleExecutor;
	}

	public void setResponsibleExecutor(String responsibleExecutor) {
		this.responsibleExecutor = responsibleExecutor;
	}

	public String getSignOfContentity() {
		return signOfContentity;
	}

	public void setSignOfContentity(String signOfContentity) {
		this.signOfContentity = signOfContentity;
	}

	public String getOrderController() {
		return orderController;
	}

	public void setOrderController(String orderController) {
		this.orderController = orderController;
	}
}
