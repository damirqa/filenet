import java.util.concurrent.ThreadLocalRandom;

/*
 * Генератор входящих документов
 */
public class IncomingGenerator extends Generator{
	
	/*
	 * Создаем документ
	 */
	protected Document create(int registrationNumber) {
		return new Incoming(name[ThreadLocalRandom.current().nextInt(9)], registrationNumber, 
				generateDate(), author[ThreadLocalRandom.current().nextInt(9)]);
	}
}
