import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.*;

public class Book {
	
	public final Pattern AUTHOR_PATTERN = Pattern.compile("<\"a itemprop=\"author\" href=\".*?\">(.*?)</a>");
	

	public Book(String title, String author, String publisher) {
		String Booktitle = title;
		String Bookauthor = author;
		String Bookpublisher = author;
	}

	public Book(String[] bookInfo) {
		// TODO Auto-generated constructor stub
	}

	//constructor for one book
	public static Book book (int ISBN){
		//needs to get author, publisher, and title of book from online
		//String bookURL = getBookURL(ISBN);
		return new Book(getBookInfo(ISBN));
	}

	public static String getHTML(String url) {
		try {
			URLConnection socket = new URL(url).openConnection();
			Scanner text = new Scanner(socket.getInputStream());
			text.useDelimiter("\\Z"); //checks for end of html
			return text.next();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public static String[] getBookInfo(int ISBN){
		String bookInfo[] = new String[8];
		String html = getHTML("http://isbndb.com/search/all?query=" +  String.valueOf(ISBN));
		
		


		 
		/*index associatio
		 * 0 = title
		 * 1 = author
		 * 2 = genre
		 * 3 = release date
		 * 4 = publisher
		 * 5 = book # in series
		 * 6 = pages
		 * 7 = chapters
		 */
		return bookInfo;
	}

}
