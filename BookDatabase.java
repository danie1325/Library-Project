import java.util.Hashtable;

public class BookDatabase {
	static //create a hashmap
	Hashtable bookDatabase = new Hashtable();

	/*make book object and have that be stored in the hashmap
	 * book object stores author, title, publisher, review, etc
	 * hashmap key = ISBN number
	 */

	public static void registerBook(int ISBN){
		
		bookDatabase.put(ISBN, Book.book(ISBN)); //is this correct?
	}

	

}
