public class Runner {

	public static void main(String[] args) {
		Factory incomingFactory = new Factory(new IncomingBlacksmith());
		System.out.println(incomingFactory.manufactureDocument());
		
		Factory outgoingFactory = new Factory(new OutgoingBlacksmith());
		System.out.println(outgoingFactory.manufactureDocument());
		
		Factory taskFactory = new Factory(new TaskBlacksmith());
		System.out.println(taskFactory.manufactureDocument());
	}
}
