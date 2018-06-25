import java.util.concurrent.ThreadLocalRandom;

/*
 * Генератор входящих документов
 */
public class IncomingGenerator extends Generator{
	
	/*
	 * Создаем документ
	 */
	protected Document create(int regNumber) {
		return new Incoming(name[ThreadLocalRandom.current().nextInt(9)], null, 
				regNumber, generateDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], 
				addresser[ThreadLocalRandom.current().nextInt(9)], addressee[ThreadLocalRandom.current().nextInt(9)], 
				ThreadLocalRandom.current().nextInt(1000), generateDate());
	}
}
