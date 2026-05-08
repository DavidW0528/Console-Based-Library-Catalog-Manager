package libraryCatalogPackage;

import java.util.*;

public class Student {
	private Name name;
	private int studentID;
	private ArrayList<Loan> loans;
	
	public Student() {
		this(new Name("John", "Doe"), 0);
	}//Ends empty Student constructor
	
	public Student(Name name, int studentID) {
		setName(name);
		setStudentID(studentID);
		setLoans(new ArrayList<>());
	}//Ends full Student constructor
	
	public Name getName() {
		return name;
	}//Ends name getter
	
    public Date getDueDate(String isbn) {
        for (Loan loan : loans) {
            if (loan.getBook().getIsbn().equals(isbn)) {
                return loan.getDueDate();
            }//Ends if statement
        }//Ends for loop
        return null;
    }//Ends dueDate getter
	
	public int getStudentID() {
		return studentID;
	}//Ends studentID getter
	
	public ArrayList<Loan> getLoans() {
		return loans;
	}//Ends checkedOutBooks getter
	
	
	public void setName(Name name) {
		this.name = name;
	}//Ends name setter
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}//Ends studentID setter
	
	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}//Ends checkedOutBooks setter
	

	public void checkOutBook(Book book) {
        Date today = Helpers.getCurrentDate();
        loans.add(new Loan(book, today));
        book.setAvailable(false);
    }//Ends checkOutBook
	
	public boolean returnBook(String isbn) {
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getBook().getIsbn().equals(isbn)) {
            	loans.get(i).getBook().setAvailable(true);
                loans.remove(i);
                return true;
            }//Ends if statement
        }//Ends for loop
        return false;
    }//Ends returnBook method

	public boolean renewBook(String isbn) {
        for (Loan loan : loans) {
            if (loan.getBook().getIsbn().equals(isbn)) {
                return loan.renew();
            }//Ends if statement
        }//Ends for loop
        return false;
    }//Ends renewBook method


	@Override
	public String toString() {
	    String result = "Student Name: " + name +
	                    "\nStudent ID: " + studentID +
	                    "\nBook Loans: ";
	
	    if (loans.isEmpty()) {
	        result += "None\n";
	    } else {
	        for (Loan loan : loans) {
	            result += "- " + loan + "\n";
	        }//Ends for loop
	    }//Ends if-else statement
	
	    return result;
	}//Ends toString

}//Ends Student class

