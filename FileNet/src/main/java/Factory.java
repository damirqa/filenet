public class Factory {
	
	private final Blacksmith blacksmith;
	
	public Factory(Blacksmith blacksmith) {
		this.blacksmith = blacksmith;
	}
	
	/*
	 * blacksmith создает свой документ в зависимости от типа
	 */
	public Document manufactureDocument() {
		Document document = null;
		try {
			document = this.blacksmith.manufactureDocument();
		} catch (DocumentExistsException e) {
			e.printStackTrace();
		}
		return document;
	}
	
}