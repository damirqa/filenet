import java.util.Date;

//Класс "Поручение"

public class Task  extends Document {
	
	// Что с типами?
	
	private Date dateIssue; // Дата выдачи поручения
	private int termExecutionOfInstructions; // срок испольнения поручения
	private String responsibleExecutor; // ответственный испольнитель
	private String signOfContentity; //признак контрольности
	
	
	public int compareTo(Document arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
