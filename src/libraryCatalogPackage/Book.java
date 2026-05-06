package libraryCatalogPackage;

import java.util.ArrayList;

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
	
	public Book(String title, ArrayList<String> authors, String publisher, String isbn, int publicationYear,
			String edition, String callNumber, String format, boolean isAvailable) {
		super();
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.edition = edition;
		this.callNumber = callNumber;
		this.format = format;
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
