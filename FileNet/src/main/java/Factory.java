/*
 * Класс Фабрика
 */
public class Factory {
	
	private final Generator blacksmith;
	
	public Factory(Generator blacksmith) {
		this.blacksmith = blacksmith;
	}
	
	/*
	 * blacksmith создает свой документ в зависимости от типа
	 */
	public void manufactureDocument() {
		Document document;
		try {
			document = this.blacksmith.manufactureDocument();
		} catch (DocumentExistsException e) {
			e.printStackTrace();
		}
	}
}