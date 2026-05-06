package libraryCatalogPackage;

import java.util.ArrayList;

// Represents what a book is to this program
/* This class encapsulates all parameters and behaviors 
 * related to a book, allowing the catalog logic to remain
 * independent from data storage
*/

public class Book {
	private String title;
	private ArrayList<String> authors;
	private String publisher;
	String isbn;
	int publicationYear;
	String edition;
	String callNumber;
	String format; 
	boolean isAvailable;
	
	public Book() {
		super();
		this.title = "Unknown Title";
		this.authors = new ArrayList<>();
		this.publisher = "Unknown Publisher";
		this.isbn = "N/A";
		this.publicationYear = -1;
		this.edition = "N/A";
		this.callNumber = "N/A";
		this.format = "N/A";
		this.isAvailable = true;
	}//Ends null Book constructor
	
	public Book(String title, ArrayList<String> authors, String publisher, String isbn, int publicationYear,
			String edition, String callNumber, String format, boolean isAvailable) {
		this();

		if (title != null && !title.isBlank()) {
        this.title = title;
		}//Ends if statement

	    if (authors != null) {
	        this.authors = authors;
	    }//Ends if statement
	
	    if (publisher != null && !publisher.isBlank()) {
	        this.publisher = publisher;
	    }//Ends if statement
	
	    if (isbn != null && !isbn.isBlank()) {
	        this.isbn = isbn;
	    }//Ends if statement
	
	    if (publicationYear >= 1450) {
	        this.publicationYear = publicationYear;
	    }//Ends if statement
	
	    if (edition != null && !edition.isBlank()) {
	        this.edition = edition;
	    }//Ends if statement
	    

	    if (callNumber != null && !callNumber.isBlank()) {
        this.callNumber = callNumber;
	    }//Ends if statement

	    if (format != null && !format.isBlank()) {
	    	this.format = format;
	    }//Ends if statement
	    
	    this.isAvailable = isAvailable;

	}//Ends Book constructor

	
	public String getTitle() {
		return title;
	}//Ends title getter

	public void setTitle(String title) {
		this.title = title;
	}//Ends title setter

	public ArrayList<String> getAuthors() {
		return authors;
	}//Ends author getter

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}//Ends author setter

	public String getPublisher() {
		return publisher;
	}//Ends publisher getter

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}//Ends publisher setter

	public String getIsbn() {
		return isbn;
	}//Ends isbn getter

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}//Ends isbn setter

	public int getPublicationYear() {
		return publicationYear;
	}//Ends publication year getter

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}//Ends publication year setter
	
	public String getEdition() {
		return edition;
	}//Ends edition getter
	
	public void setEdition(String edition) {
		this.edition = edition;
	}//Ends edition setter

	public String getCallNumber() {
		return callNumber;
	}//Ends call number getter

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}//Ends call number setter

	public String getFormat() {
		return format;
	}//Ends format getter

	public void setFormat(String format) {
		this.format = format;
	}//Ends format setter

	public boolean isAvailable() {
		return isAvailable;
	}//Ends availability getter

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}//Ends availability setter

	
	@Override
	public String toString() {
		String availability = "Unknown";
		
		if(isAvailable == true) {
			availability = "Available";
		} else if(isAvailable == false) {
			availability = "Unavailable";
		}//Ends if-else-if
		
		return "Title: " + title + 
				"\nAuthors: " + authors + 
				"\nPublisher: " + publisher + 
				"\nISBN: " + isbn
				+ "\nPublication Year: " + publicationYear + 
				"\nEdition: " + edition +
				"\nCall Number: " + callNumber + 
				"\nFormat: " + format + 
				"\nAvailability: " + availability;
	}//Ends Book toString
	
}//Ends Book class
