import java.util.concurrent.ThreadLocalRandom;

/*
 * Генератор исходящих документов
 */
public class OutgoingGenerator extends Generator{
	
	private String[] deliverymethod = {"Курьерская доставка", "Доставка почтовой службой", 
			"Доставка транспортными компаниями"};
	
	/*
	 * Создаем документ
	 */
	protected Document create(int regNumber) {
		return new Outgoing(name[ThreadLocalRandom.current().nextInt(9)], null,
				ThreadLocalRandom.current().nextInt(1000), generateDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], addresser[ThreadLocalRandom.current().nextInt(9)], 
				deliverymethod[ThreadLocalRandom.current().nextInt(2)]);
	}
}
