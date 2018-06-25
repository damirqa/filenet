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
	protected Document create(int regNumber) {
		return new Task(name[ThreadLocalRandom.current().nextInt(9)], null, 
				ThreadLocalRandom.current().nextInt(1000), generateDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], generateDate(), 
				ThreadLocalRandom.current().nextInt(100),
				null, null, null);
	}

	
}
