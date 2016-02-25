import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Set;

public class BookDatabase {
    //create a hashmap called book database 
	static Hashtable<Integer, Book> bookDatabase = new Hashtable();

	/*make book object and have that be stored in the hashmap
	 * book object stores author, title, publisher, review, etc
	 * hashmap key = ISBN number
	 */

	public static void registerBook(int ISBN) {
		Book book = Book.createBook(ISBN);
		bookDatabase.put(ISBN, book); 
	}
	
	public static void writeFile(Hashtable h) {
		Set<String> key = h.keySet();
		String[] keyArray = key.toArray(new String[key.size()]);
		for (int i = 0; i < h.size(); i++) {
			String k = keyArray[i];
			Object v = h.get(i);
			try {
				PrintWriter out = new PrintWriter("Database.txt");
				out.println("ISBN is " + k);
				out.println(v);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


}
	


