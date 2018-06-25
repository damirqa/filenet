import java.util.SortedSet;
import java.util.TreeSet;

public class Repository {

	public static SortedSet<Document> STORAGE = new TreeSet<Document>();
	
	/*
	 * Получаем список авторов с документами
	 */
	public static SortedSet<String> getAuthorsWithDocuments() {
		
		SortedSet<String> authorWithDocument = new TreeSet<String>();
		
		for (String author : Generator.author) {
			for (Document document : STORAGE) {
				if (author.equals(document.getAuthor())) {
					authorWithDocument.add(author);
				}
			}
		}
		return authorWithDocument;	
	}
	
	/*
	 * Выводим отчет
	 */
	public static void printReport() {
		
		SortedSet<String> authors = getAuthorsWithDocuments();
		
		for (String author : Generator.author) {
			System.out.println(author + ":");
			for (Document document : STORAGE) {
				if (author.equals(document.getAuthor())) {
					System.out.println("\t" + document);
				}
			}
		}
		
	}
}
