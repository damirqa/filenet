import java.util.Date;

// Класс "Документ"

public abstract class Document implements Comparable<Document> {
	
	// Что с типами
	
	// Исправить модификатор доступа
	protected int id; // Идентификатор документа
	protected String name; // Название документа
	protected String text; // Текст документа
	protected int registrationNumber; // Регистрационный номер документа
	protected Date dateRegistration; // Дата регистрации документа
	protected String author; // Автор документа

	// Сравниваем сначала по дате регистрации, а затем по регистрационному номеру
	public int compareTo(Document doc) {
		
		Document document = (Document) doc;
		
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

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private String getText() {
		return text;
	}

	private void setText(String text) {
		this.text = text;
	}

	private int getRegistrationNumber() {
		return registrationNumber;
	}

	private void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	private Date getDateRegistration() {
		return dateRegistration;
	}

	private void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	private String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		this.author = author;
	}
	
//	public Document(int reg, Date date) {
//		this.registrationNumber = reg;
//		this.dateRegistration = date;
//	}

}
