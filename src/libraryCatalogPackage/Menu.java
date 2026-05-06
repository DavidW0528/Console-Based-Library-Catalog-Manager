package libraryCatalogPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	public static void runMenu() {
		Scanner input = new Scanner(System.in);
		ArrayList<Book> bookCatalog = new ArrayList<>();;
	    int menuChoice;
	
	    do {
	        Helpers.billboard("Library Catalog");
	        System.out.println("1. Add Book");
	        System.out.println("2. Search");
	        System.out.println("3. Display All Book Information");
	        System.out.println("4. Wipe a Book From the Catalog");
	        System.out.println("5. Exit");
	        System.out.print("Enter choice: ");
	        menuChoice = input.nextInt();
	        input.nextLine();
	
	        switch (menuChoice) {
	            case 1:
	            	Helpers.clearConsole();
	            	addBook(input, bookCatalog);
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	            	break;
	            case 2: 
	            	Helpers.clearConsole();
	            	searchBooks(bookCatalog, input);
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	            	break;
	            case 3: displayBooks(bookCatalog, input);
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	            	break;
	            case 4: 
	            	Helpers.clearConsole();
	            	wipeBook(bookCatalog, input);
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	            	break;
	            case 5: 
	            	System.out.println("Goodbye!");
	            	break;
	            default: 
	            	Helpers.clearConsole();
	            	System.out.println("Invalid choice.");
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	        }//Ends switch-case
	    } while (menuChoice != 5);
	}//Ends runMenu method
	
	
	public static void addBook(Scanner input, ArrayList<Book> bookCatalog) {
		Helpers.clearConsole();
		System.out.print("Enter the book title: ");
		String title = input.nextLine();
		
		ArrayList<String> authors = new ArrayList<>();
		String author = "";
		while(!"Q".equals(author)) {
			System.out.println("Enter 'Q' when there are no more authors");
			System.out.print("Enter the authors name: ");
			author = input.nextLine().trim();
			if (!author.equals("Q")) {
				authors.add(new String(author));
			}//Ends if
		}//Ends while loop
		
		System.out.print("Enter the publishers name: ");
		String publisher = input.nextLine();
		
		System.out.print("Enter the ISBN: ");
		String isbn = input.nextLine();
		
		System.out.print("Enter the publication year: ");
		int publicationYear = input.nextInt();
		input.nextLine();
		
		System.out.print("Enter the edition: ");
		String edition = input.nextLine();
		
		System.out.print("Enter the call number: ");
		String callNumber = input.nextLine();
		
		int typeSelection;
		do {
		    System.out.print("Enter format:\n1. Hardcover\n2. Paperback\nChoice: ");
		    typeSelection = input.nextInt();
		    input.nextLine();
		} while (typeSelection != 1 && typeSelection != 2);
		
		String format;
		if (typeSelection == 1) {
		    format = "Hardcover";
		} else {
		    format = "Paperback";
		}//Ends if-else
		
		boolean isAvailable;
		String availabilitySelection = "Q";

		while(!availabilitySelection.equals("yes") && !availabilitySelection.equals("no")) {
			System.out.print("Is this book still available?: ");
			availabilitySelection = input.nextLine().toLowerCase();
		}//Ends while loop
		
		if(availabilitySelection.equals("yes")) {
			isAvailable = false;
		} else {
			isAvailable = true;
		}//Ends if-else
		bookCatalog.add(new Book(title, authors, publisher, isbn, publicationYear, edition, callNumber, format, isAvailable));
	}//Ends addFish method
	
	
	public static void displayBooks(ArrayList<Book> bookCatalog, Scanner input) {
		Helpers.clearConsole();
		Helpers.billboard("Book Data Display");
		
		int displayChoice;
		
		System.out.println("1. Display All Books\n2. Display a Single Book ");
		System.out.print("Enter choice: ");
		
        displayChoice = input.nextInt();
        input.nextLine();
        Helpers.clearConsole();
        
        switch (displayChoice) {
        case 1: 
        	if(bookCatalog.isEmpty()) {
    			System.out.println("There are no books in the catalog");
    			break;
    		}//Ends if
    		
    		for(Book book : bookCatalog) {
    			System.out.println(book.toString());
    			System.out.println();
    		}//Ends for loop
    		break;
        case 2:

			if (bookCatalog.isEmpty()) {
	            System.out.println("There are no books in the catalog.");
	            Helpers.pause(input);
	            break;
	        }//Ends if
	
	        System.out.print("Enter the ISBN of the book to display: ");
	        String searchIsbn = input.nextLine().trim();
	
	        boolean found = false;
	
	        for (Book book : bookCatalog) {
	            if (book.getIsbn().equals(searchIsbn)) {
	                System.out.println();
	                System.out.println(book);
	                found = true;
	                Helpers.pause(input);
	                break;
	            }//Ends if
	        }//Ends for loop
	
	        if (!found) {
	            System.out.println("No book found with that ISBN.");
	        }//Ends if
	        Helpers.pause(input);
	        break;
        default:
	        System.out.println("Invalid choice.");
	        Helpers.pause(input);
        }//Ends switch-case
		
	}//Ends displayBooks
	
	
	public static void searchBooks(ArrayList<Book> bookCatalog, Scanner input) {
		Helpers.clearConsole();
		Helpers.billboard("Book Search");
		
	    if (bookCatalog.isEmpty()) {
	        System.out.println("There are no books in the catalog.");
	        return;
	    }//Ends if

	    System.out.println("Leave any field blank to skip it.");

	    System.out.print("Title: ");
	    String titleInput = input.nextLine().toLowerCase();

	    System.out.print("Author: ");
	    String authorInput = input.nextLine().toLowerCase();

	    System.out.print("Publisher: ");
	    String publisherInput = input.nextLine().toLowerCase();

	    System.out.print("ISBN: ");
	    String isbnInput = input.nextLine();

	    System.out.print("Publication Year: ");
	    String yearInput = input.nextLine();

	    boolean foundAny = false;

	    for (Book book : bookCatalog) {
	        boolean matches = true;

	        //Title check
	        if (!titleInput.isEmpty() &&
	            !book.getTitle().toLowerCase().contains(titleInput)) {
	            matches = false;
	        }//Ends if

	        //Author check
	        if (!authorInput.isEmpty()) {
	            boolean authorMatch = false;
	            for (String author : book.getAuthors()) {
	                if (author.toLowerCase().contains(authorInput)) {
	                    authorMatch = true;
	                    break;
	                }//Ends if
	            }//Ends for loop
	            if (!authorMatch) {
	                matches = false;
	            }//Ends if
	        }//Ends if

	        //Publisher check
	        if (!publisherInput.isEmpty() &&
	            !book.getPublisher().toLowerCase().contains(publisherInput)) {
	            matches = false;
	        }//Ends if

	        //ISBN check
	        if (!isbnInput.isEmpty() &&
	            !book.getIsbn().equals(isbnInput)) {
	            matches = false;
	        }//Ends if

	        //Year check
	        if (!yearInput.isEmpty()) {
	            try {
	                int year = Integer.parseInt(yearInput);
	                if (book.getPublicationYear() != year) {
	                    matches = false;
	                }//Ends if
	            } catch (NumberFormatException e) {
	                matches = false;
	            }//Ends try-catch
	        }//Ends if

	        if (matches) {
	            System.out.println(book);
	            System.out.println();
	            foundAny = true;
	        }//Ends if
	    }//Ends for loop

	    if (!foundAny) {
	        System.out.println("No books matched your search criteria.");
	    }//Ends if
	}//Ends searchBooks
	
	
	public static void wipeBook(ArrayList<Book> bookCatalog, Scanner input) {
		if(bookCatalog.isEmpty()) {
			System.out.println("There are no books in the catalog");
			return;
		}//Ends if
		
		System.out.println("Enter the ISBN of the book you would like to remove: ");
		String isbnToRemove = input.nextLine().trim();
		
		for (int i = 0; i < bookCatalog.size(); i++) {
			if(bookCatalog.get(i).getIsbn().equals(isbnToRemove)) {
				bookCatalog.remove(i);
				System.out.println("Book removed successfully");
				return;
			}//Ends if
		}//Ends for loop
		
		System.out.println("No book found with the given ISBN");
	}//Ends wipeBook
}//Ends Menu class
