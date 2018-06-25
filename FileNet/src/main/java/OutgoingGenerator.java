import java.util.concurrent.ThreadLocalRandom;

/*
 * Генератор исходящих документов
 */
public class OutgoingGenerator extends Generator{
	
	/*
	 * Создаем документ
	 */
	protected Document create(int registrationNumber) {
		return new Outgoing(name.get(ThreadLocalRandom.current().nextInt(2)), registrationNumber, 
				generateDate(), author.get(ThreadLocalRandom.current().nextInt(9)));
		
	}
}
