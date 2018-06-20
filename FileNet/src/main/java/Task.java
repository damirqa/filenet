import java.util.Date;

/*
 * Класс Поручение
 */
public class Task  extends Document {

	private Date dateIssue; // Дата выдачи поручения
	private int termExecutionOfInstructions; // Срок исполнения поручения
	private String responsibleExecutor; // Ответственный исполнитель
	private String signOfContentity; // Признак контрольности
	private String orderController; // Контролер поручения
	
	public Task(String name, String text, int registrationNumber, Date dateRegistration, String author,
			Date dateIssue, int termExecutionOfInstructions, String responsibleExecutor, String signOfContentity, String orderController) {
		
		setCounter();
		setId();
		
		setName(name);
		setText(text);
		setRegistrationNumber(registrationNumber);
		setDateRegistration(dateRegistration);
		setAuthor(author);
		
		this.dateIssue = dateIssue;
		this.termExecutionOfInstructions = termExecutionOfInstructions;
		this.responsibleExecutor = responsibleExecutor;
		this.signOfContentity = signOfContentity;
		this.orderController = orderController;
		
	}

	@Override
	public String toString() {
		return "Поручение №" + getRegistrationNumber() + " от " + getDateRegistration() + ". " + getName() + "";
	}
}
