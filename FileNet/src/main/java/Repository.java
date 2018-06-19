import java.util.ArrayList;

public class Repository implements Storable{

	private ArrayList<Document> repo;
	
	public Repository() {
		this.repo = new ArrayList<Document>();
	}
	
	public void add(Document doc) {
		this.repo.add(doc);
	}

	public int getId(Document doc) {
		return doc.getId();
	}
	
	public void info() {
		
		for (Document doc : this.repo) {
			System.out.println(doc);
		}
		
	}
}
