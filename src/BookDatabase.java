import java.util.*;
public class BookDatabase {
	static //create a hashmap
	Hashtable bookDatabase = new Hashtable();

	/*make book object and have that be stored in the hashmap
	 * book object stores author, title, publisher, review, etc
	 * hashmap key = ISBN number
	 */

	public static void registerBook(int ISBN){
		Book book = Book.createBook(ISBN);
		bookDatabase.put(ISBN, book); 
	}

	

}
