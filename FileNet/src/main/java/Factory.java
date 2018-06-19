public class Factory {
	
	private final Blacksmith blacksmith;
	
	public Factory(Blacksmith blacksmith) {
		this.blacksmith = blacksmith;
	}
	
	public Document manufactureDocument() {
		Document document = this.blacksmith.manufactureDocument();
		return document;
	}
	
}