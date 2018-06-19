import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class OutgoingBlacksmith implements Blacksmith{
	
	private String[] deliverymethod = {"Курьерская доставка", "Доставка почтовой службой", "Доставка транспортными компаниями"};

	public Document manufactureDocument() {
		return new Outgoing(name[ThreadLocalRandom.current().nextInt(9)], null,
				ThreadLocalRandom.current().nextInt(1000), setDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], addresser[ThreadLocalRandom.current().nextInt(9)], 
				deliverymethod[ThreadLocalRandom.current().nextInt(2)]);
	}
	
	public Date setDate() {
		
		int year = ThreadLocalRandom.current().nextInt(110, 118);
		int month = ThreadLocalRandom.current().nextInt(0, 11);		
		int date = ThreadLocalRandom.current().nextInt(1, 30);
		
		return new Date(year, month, date);
	}

}
