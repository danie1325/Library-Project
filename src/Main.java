import java.util.*;

public class Main {
	//what the fuck am i doing
	
	public static void main(String args[]){

		//get ISBN #
		int ISBN = getISBN();
		
		//figure out if the person is checking out a book or entering one into the database
		//person is registering a new book in the book database
		if (getProgramUse() == 0){
			BookDatabase.registerBook(ISBN);
		}
		//person is checking out a book
		else if(getProgramUse() == 1){
			//figure this shit out later!!
		}
		//person did not enter a 0 or 1
		else{
			System.out.println("Please only enter a '0' or '1'");
			////////MAKE FOR LOOP LATER BUT WHATEVER
			//person is registering a new book in the book database
			if (getProgramUse() == 0){
				BookDatabase.registerBook(ISBN);
			}
			//person is checking out a book
			else if(getProgramUse() == 1){
				//figure this shit out later!!
			}
			
		}

	}
	
	public static int getProgramUse(){
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to register a new book (enter 0) or check a book out (enter 1)?");
		int programUse = input.nextInt();
		return programUse;
	}
	
	public static int getISBN(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the book's ISBN number");
		String ISBNString = input.next();
		String[] tokenizedISBN = ISBNString.split("-");
		ISBNString = tokenizedISBN.toString();
		int ISBN = Integer.parseInt(ISBNString);
		return ISBN;
	}
}