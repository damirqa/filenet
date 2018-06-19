import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class TaskBlacksmith implements Blacksmith{

	public Document manufactureDocument() {
		
		Task task = new Task(name[ThreadLocalRandom.current().nextInt(9)], null, 
				ThreadLocalRandom.current().nextInt(1000), setDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], setDate(), 
				ThreadLocalRandom.current().nextInt(100),
				null, null, null);
		
		Repository.taskRepository.add(task);
		
		return task;
	}

	public Date setDate() {
		int year = ThreadLocalRandom.current().nextInt(110, 118);
		int month = ThreadLocalRandom.current().nextInt(0, 11);		
		int date = ThreadLocalRandom.current().nextInt(1, 30);
		
		return new Date(year, month, date);
	}

}
