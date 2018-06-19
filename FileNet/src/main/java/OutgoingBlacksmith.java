import java.util.concurrent.ThreadLocalRandom;

public class OutgoingBlacksmith extends Blacksmith{
	
	private String[] deliverymethod = {"Курьерская доставка", "Доставка почтовой службой", "Доставка транспортными компаниями"};

	public Document manufactureDocument() throws DocumentExistsException{
		
		int regNumber = ThreadLocalRandom.current().nextInt(1000);
		
		if (hasRegistrationNumber(regNumber)) {
			throw new DocumentExistsException("Документ уже существует");
		}
		else {
			Document document = create(regNumber);
			Repository.STORAGE.add(document);
			return document;
		}
	}
	
	
	protected Document create(int regNumber) {
		return new Outgoing(name[ThreadLocalRandom.current().nextInt(9)], null,
				ThreadLocalRandom.current().nextInt(1000), setDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], addresser[ThreadLocalRandom.current().nextInt(9)], 
				deliverymethod[ThreadLocalRandom.current().nextInt(2)]);
	}
}
