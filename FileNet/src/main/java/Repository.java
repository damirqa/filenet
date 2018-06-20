import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Repository {

	public static SortedSet<Document> STORAGE = new TreeSet<Document>();
	
	/*
	 * Возвращаем список авторов
	 */
	public static List<String> getListOfAuthors() {
		
		List<String> authors = Arrays.asList(Generator.author);
		return authors;
	}
	
	/*
	 * Получаем список авторов с документами
	 */
	public static SortedSet<String> getAuthorsWithDocuments(List<String> authors) {
		
		SortedSet<String> authorWithDocument = new TreeSet<String>();
		
		for (String author : authors) {
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
	public static void getReport() {
		
		SortedSet<String> authors = getAuthorsWithDocuments(getListOfAuthors());
		
		for (String author : authors) {
			System.out.println(author + ":");
			for (Document document : STORAGE) {
				if (author.equals(document.getAuthor())) {
					System.out.println("\t" + document);
				}
			}
		}
		
	}
}
