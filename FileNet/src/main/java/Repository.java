import java.util.List;
import java.util.ArrayList;

public class Repository implements Storable{

	public static List<Incoming> incomingRepository = new ArrayList<Incoming>();
	public static List<Outgoing> outgoingRepository = new ArrayList<Outgoing>();
	public static List<Task> taskRepository = new ArrayList<Task>();
	
	
//	public void add(Document doc) {
//		this.repo.add(doc);
//	}

	public int getId(Document doc) {
		return doc.getId();
	}
	
//	public void info() {
//		
//		for (Document doc : this.repo) {
//			System.out.println(doc);
//		}
//		
//	}
}
