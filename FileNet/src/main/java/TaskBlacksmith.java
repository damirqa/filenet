import java.util.concurrent.ThreadLocalRandom;

public class TaskBlacksmith extends Blacksmith{

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

	@Override
	protected Document create(int regNumber) {
		return new Task(name[ThreadLocalRandom.current().nextInt(9)], null, 
				ThreadLocalRandom.current().nextInt(1000), setDate(), 
				author[ThreadLocalRandom.current().nextInt(9)], setDate(), 
				ThreadLocalRandom.current().nextInt(100),
				null, null, null);
	}

	
}
