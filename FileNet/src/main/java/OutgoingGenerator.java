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
	protected Document create(int registrationNumber) {
		return new Outgoing(name[ThreadLocalRandom.current().nextInt(9)], registrationNumber, 
				generateDate(), author[ThreadLocalRandom.current().nextInt(9)]);
		
	}
}
