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
		return new Task(name[ThreadLocalRandom.current().nextInt(9)], registrationNumber, 
				generateDate(), author[ThreadLocalRandom.current().nextInt(9)]);
	}
}
