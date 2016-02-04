public class Book {
	
	public Book(String title, String author, String publisher) {
		String Booktitle = title;
		String Bookauthor = author;
		String Bookpublisher = author;
	}

	//constructor for one book
	public static Book book (int ISBN){
		//needs to get author, publisher, and title of book from online
		//String bookURL = getBookURL(ISBN);
		return new Book(getTitle(ISBN), getAuthor(ISBN), getPublisher(ISBN));
	}
	
	
	public static String getTitle(int ISBN){
		return "";
	}

	public static String getAuthor(int ISBN){
		return "";
	}

	public static String getPublisher(int ISBN){
		return "";
	}

}
