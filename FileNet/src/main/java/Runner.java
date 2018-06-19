import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Runner {

	public static void main(String[] args) {
		
		Factory factory = new Factory();
		
		factory.make(DocumentType.INCOMING);
		
		System.out.println(ThreadLocalRandom.current().nextInt(10));

		System.out.println(ThreadLocalRandom.current().nextInt(10));

		System.out.println(ThreadLocalRandom.current().nextInt(100, 1000));

	}
}
