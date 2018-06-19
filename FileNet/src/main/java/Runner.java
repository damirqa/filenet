public class Runner {

	public static void main(String[] args) {
		
		Factory factory = new Factory();
		
		factory.make(DocumentType.INCOMING);
		factory.make(DocumentType.OUTGOING);
		factory.make(DocumentType.TASK);
		
		factory.info();
	}
}
