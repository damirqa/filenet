import java.util.Date;

//  ласс "документ"

public abstract class Document implements Comparable<Document>{
	
	// „то с типами?
	
	private int id; // идентификатор документа
	private String name; // название докумениа
	private String text; // текст документа
	private int registrationNumber; // регистрационный номер документа
	private Date dateRegistration; // ƒата регистрации документа
	private String author; //автор документа

}
