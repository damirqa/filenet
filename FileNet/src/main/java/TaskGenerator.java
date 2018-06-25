import java.util.concurrent.ThreadLocalRandom;

/*
 * Метод создает "Поручение" и сохрянает в хранилище.
 * Если документ уже существует, то выбрасывается исключение
 */
public class TaskGenerator extends Generator{

	/*
	 * Создаем документ
	 */
	@Override
	protected Document create(int registrationNumber) {
		return new Task(name.get(ThreadLocalRandom.current().nextInt(9)), registrationNumber, 
				generateDate(), author.get(ThreadLocalRandom.current().nextInt(9)));
	}
}
