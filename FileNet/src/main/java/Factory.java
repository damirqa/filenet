/*
 * Класс Фабрика
 */
public class Factory {
	
	private final Generator generator;
	
	public Factory(Generator generator) {
		this.generator = generator;
	}
	
	/*
	 * blacksmith создает свой документ в зависимости от типа
	 */
	public void manufactureDocument() {
		try {
			Document document = this.generator.manufactureDocument();
		} catch (DocumentExistsException e) {
			e.printStackTrace();
		}
	}
}