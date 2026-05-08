package libraryCatalogPackage;

import java.util.ArrayList;
import java.util.Scanner;



public class Menu {
	
	public static void runMenu() {
		Scanner input = new Scanner(System.in);
        ArrayList<Book> bookCatalog = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            Helpers.billboard("Library System");
            System.out.println("1. Library Catalog");
            System.out.println("2. Loan Management");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> libraryCatalogMenu(input, bookCatalog);
                case 2 -> loanMenu(input, bookCatalog, students);
            }//Ends switch-case
        } while (choice != 3);

		
	}//Ends runMenu method
	
	public static void libraryCatalogMenu(Scanner input, ArrayList<Book> bookCatalog) {
		int menuChoice;
		
	    do {
	        Helpers.billboard("Library Catalog");
	        System.out.println("1. Add Book");
	        System.out.println("2. Multi-Field Search");
	        System.out.println("3. Display All Book Information");
	        System.out.println("4. Wipe a Book From the Catalog");
	        System.out.println("5. ISBN Search");
	        System.out.println("6. Back");
	        System.out.print("Enter choice: ");
	        menuChoice = input.nextInt();
	        input.nextLine();
	
	        switch (menuChoice) {
	            case 1:
	            	addBook(input, bookCatalog);
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	            	break;
	            case 2: 
	            	searchBooks(bookCatalog, input);
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	            	break;
	            case 3: 
	            	displayBooks(bookCatalog, input);
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
	    	            }//Ends if
	    	            
	    	            if (!found) {
		    	            System.out.println("No book found with that ISBN.");
		    	            break;
		    	        }//Ends if
	    	        }//Ends for loop
	    	        Helpers.pause(input);
	    	        break;
	    	        
	            case 6:
	            	break;
	    	        
	            default: 
	            	Helpers.clearConsole();
	            	System.out.println("Invalid choice.");
	            	Helpers.pause(input);
	            	Helpers.clearConsole();
	        }//Ends switch-case
	    } while (menuChoice != 6);
	}//Ends libraryCatalogMenu method
	

	private static void loanMenu(Scanner input, ArrayList<Book> catalog, ArrayList<Student> students) {
        int choice;
        do {
            Helpers.clearConsole();
            Helpers.billboard("Loan Management");
            System.out.println("1. Add Student");
            System.out.println("2. Checkout Book");
            System.out.println("3. Return Book");
            System.out.println("4. Renew Book");
            System.out.println("5. Check Due Date");
            System.out.println("6. Back");
            System.out.print("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> addStudent(input, students);
                case 2 -> checkoutBook(input, students, catalog);
                case 3 -> returnBook(input, students);
                case 4 -> renewBook(input, students);
                case 5 -> checkDueDate(input, students);
            }//Ends switch-case
        } while (choice != 6);
    }//Ends loanMenu method

	
	private static Student findStudent(Scanner input, ArrayList<Student> students) {
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (Student s : students) {
            if (s.getStudentID() == id) return s;
        }//Ends for loop
        System.out.println("Student not found.");
        Helpers.pause(input);
        return null;
    }//Ends findStudent method


	private static void addStudent(Scanner input, ArrayList<Student> students) {
        System.out.print("First Name: ");
        String f = input.nextLine();
        System.out.print("Last Name: ");
        String l = input.nextLine();
        System.out.print("Student ID: ");
        int id = input.nextInt();
        input.nextLine();
        students.add(new Student(new Name(f, l), id));
    }//Ends addStudent method

    private static void checkoutBook(Scanner input, ArrayList<Student> students, ArrayList<Book> catalog) {
        Student student = findStudent(input, students);
        if (student == null) return;

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                student.checkOutBook(book);
                System.out.println("Book checked out.");
                Helpers.pause(input);
                return;
            }//Ends if statement
        }//Ends for loop
        System.out.println("Book unavailable.");
        Helpers.pause(input);
    }//Ends checkoutBook method

    private static void returnBook(Scanner input, ArrayList<Student> students) {
        Student student = findStudent(input, students);
        if (student == null) return;

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        System.out.println(student.returnBook(isbn) ? "Book returned." : "Book not found.");

        Helpers.pause(input);
    }//Ends returnBook method

    private static void renewBook(Scanner input, ArrayList<Student> students) {
        Student student = findStudent(input, students);
        if (student == null) return;

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        System.out.println(student.renewBook(isbn) ? "Book renewed." : "Renewal failed.");

        Helpers.pause(input);
    }//Ends renewBook method
    

    private static void checkDueDate(Scanner input, ArrayList<Student> students) {
        Student student = findStudent(input, students);
        if (student == null) return;

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        Date due = student.getDueDate(isbn);
        System.out.println(due != null ? "Due: " + due : "Book not found.");

        Helpers.pause(input);
    }//Ends checkDueDate method
	
	
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

		System.out.print("Enter format:\n1. Hardcover\n2. Paperback\n3. Audiobook\n4. Online\nChoice: ");
		typeSelection = input.nextInt();
		input.nextLine();
		
		String format;
		if (typeSelection == 1) {
		    format = "Hardcover";
		} else if(typeSelection == 2){
		    format = "Paperback";
		} else if(typeSelection == 3) {
			format = "Audiobook";
		} else if(typeSelection == 4){
			format = "Online";
		} else {
			format = "";
		}//Ends if-else-if-else-if
		
		boolean isAvailable;
		String availabilitySelection = "Q";

		while(!availabilitySelection.equals("yes") && !availabilitySelection.equals("no")) {
			System.out.print("Is this book still available?: ");
			availabilitySelection = input.nextLine().toLowerCase();
		}//Ends while loop
		
		if(availabilitySelection.equals("yes")) {
			isAvailable = true;
		} else {
			isAvailable = false;
		}//Ends if-else
		bookCatalog.add(new Book(title, authors, publisher, isbn, publicationYear, edition, callNumber, format, isAvailable));
	}//Ends addFish method
	
	
	public static void displayBooks(ArrayList<Book> bookCatalog, Scanner input) {
		Helpers.clearConsole();
		Helpers.billboard("Book Data Display");

    	if(bookCatalog.isEmpty()) {
			System.out.println("There are no books in the catalog");
		} else {
		
			for(Book book : bookCatalog) {
				System.out.println(book.toString());
				System.out.println();
			}//Ends for loop
		}//Ends if-else statement
		
        Helpers.pause(input);
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

