import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.*;

public class Book {
	//find some of this info later
	public final static Pattern TITLE_PATTERN = Pattern.compile("<h1 itemprop=\"name\">(.*?)</h1>"); //done
	public final static Pattern AUTHOR_PATTERN = Pattern.compile("<\"a itemprop=\"author\" href=\".*?\">(.*?)</a>"); //done
	public final static Pattern GENRE_PATTERN = Pattern.compile("<h2>Subjects>.*?<\"a itemprop=\"\" href=\".*?\">(.*?)</a>"); //done

	//public final static Pattern RELEASE_DATE_PATTERN = Pattern.compile("<a href=\".*?\">(.*?)</a>"); //not done
	public final static Pattern PUBLISHER_PATTERN = Pattern.compile("<\"a itemprop=\"publisher\"href=\".*?\">(.*?)</a>"); //done
	//public final static Pattern BOOK_NUM_PATTERN = Pattern.compile("<a href=\".*?\">(.*?)</a>"); //not done
	//public final static Pattern PAGES_PATTERN = Pattern.compile("<a href=\".*?\">(.*?)</a>");//not done
	//public final static Pattern CHAPTERS_PATTERN = Pattern.compile("<a href=\".*?\">(.*?)</a>"); //not done
	
	
	public Book(String title, String author, String publisher, String genre) {
		String bookTitle = title;
		String bookAuthor = author;
		String bookPublisher = author;
		String bookGenre = genre;
	}

	public Book(String[] bookInfo) {
		// TODO Auto-generated constructor stub
	}

	//constructor for one book
	public static Book createBook(int ISBN){
		//needs to get author, publisher, and title of book from online
		//String bookURL = getBookURL(ISBN);
		Book book = new Book((getBookInfo(ISBN))[0], (getBookInfo(ISBN))[1], (getBookInfo(ISBN))[2], (getBookInfo(ISBN))[3]);
		return book;
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
		/*index association
		 * 0 = title
		 * 1 = author
		 * 2 = genre
		 * 3 = publisher
		 * 4 = release date
		 * 5 = book # in series
		 * 6 = pages
		 * 7 = chapters
		 */
		String bookInfo[] = new String[4];
		String html = getHTML("http://isbndb.com/search/all?query=" +  String.valueOf(ISBN));
		
		Matcher Title_Matcher = TITLE_PATTERN.matcher(html);
		
		if (Title_Matcher.find()) {
			bookInfo[0] = Title_Matcher.group(1);
		}
		
		
		Matcher Author_Matcher = AUTHOR_PATTERN.matcher(html);
		
		if (Author_Matcher.find()) {
			bookInfo[1] = Author_Matcher.group(1);
		}
		
		Matcher Genre_Matcher = GENRE_PATTERN.matcher(html);
		
		if (Genre_Matcher.find()) {
			bookInfo[2] = Genre_Matcher.group(1);
		}
		
		Matcher Publisher_Matcher = PUBLISHER_PATTERN.matcher(html);
		
		if (Publisher_Matcher.find()) {
			bookInfo[3] = Publisher_Matcher.group(1);
		}
		


		 
		
		return bookInfo;
	}

}
