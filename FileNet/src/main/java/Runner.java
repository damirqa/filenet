import java.util.Date;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		
		System.out.println("Введите цифру и нажмите на Enter, чтобы создать \n"
				+ "1. Входящий документ \n"
				+ "2. Исходящий документ \n"
				+ "3. Поручение \n"
				+ "Для получения отчета нажмите 4. \n"
				+ "Закрыть программу - 5");
		
		Scanner scanner = new Scanner(System.in);
				
		while(true) {
			
			switch (scanner.nextInt()) {
				case 1:
					getIncoming();
					break;
				case 2:
					getOutgoing();
					break;
				case 3:
					getTask();
					break;
				case 4:
					Repository.getReport();
					break;
				case 5:
					System.exit(0);
					break;
			}
		}
	}
	
	private static void getIncoming() {
		Factory incomingFactory = new Factory(new IncomingGenerator());
		incomingFactory.manufactureDocument();
	}
	
	private static void getOutgoing() {
		Factory outgoingFactory = new Factory(new OutgoingGenerator());
		outgoingFactory.manufactureDocument();
	}
	
	private static void getTask() {
		Factory taskFactory = new Factory(new TaskGenerator());
		taskFactory.manufactureDocument();
	}
}
