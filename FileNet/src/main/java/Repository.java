import java.util.List;
import java.util.ArrayList;

public class Repository implements Storable{

	public static List<Document> STORAGE = new ArrayList<Document>();

	public int getId(Document doc) {
		return doc.getId();
	}
}
