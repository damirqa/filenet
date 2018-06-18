import java.util.Date;

// класс Поручение

public class Task  extends Document {
	
	// Что с типами?

	private Date dateIssue; // Дата выдачи поручения
	private int termExecutionOfInstructions; // Срок исполнения поручения
	private String responsibleExecutor; // Ответственный исполнитель
	private String signOfContentity; // Признак контрольности
	private String orderController; // Контролер поручения
	
	@Override
	public String toString() {
		return "Поручение [Дата выдачи поручения=" + dateIssue + ", Срок исполнения поручения=" + termExecutionOfInstructions
				+ ", Ответственный исполнитель=" + responsibleExecutor + ", Признак контрольности=" + signOfContentity
				+ ", Контролер поручения=" + orderController + ", ID=" + id + ", Название=" + name + ", Регистрационный номер="
				+ registrationNumber + ", Автор=" + author + "]";
	}


	public int compareTo(Document arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
