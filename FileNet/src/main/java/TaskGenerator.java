import java.util.concurrent.ThreadLocalRandom;

public class TaskGenerator extends Generator{

	/*
	 * Создаем документ
	 */
	@Override
	protected Document create(int registrationNumber) {
		return new Task(name.get(ThreadLocalRandom.current().nextInt(2)), registrationNumber, 
				generateDate(), author.get(ThreadLocalRandom.current().nextInt(9)));
	}
}
