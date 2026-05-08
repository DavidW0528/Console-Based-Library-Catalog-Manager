package libraryCatalogPackage;

public class Loan {

	private Book book;
	private Date checkoutDate;
	private Date dueDate;
	private int renewalCount;
	private static final int MAX_RENEWALS = 3;
	
	public Loan(Book book, Date checkoutDate) {
		setBook(book);
		setCheckoutDate(checkoutDate);
		setRenewalCount(0);
		setDueDate(checkoutDate, 3);
	}//Ends full Loan constructor
	
	public Book getBook() {
		return book;
	}//Ends book getter
	
	public Date getCheckoutDate() {
		return checkoutDate;
	}//Ends checkoutDate getter
	
	public Date getDueDate() {
		return dueDate;
	}//Ends dueDate getter
	
	public int getRenewalCount() {
		return renewalCount;
	}//Ends renewalCount getter
	
	public void setBook(Book book) {
		this.book = book;
	}//Ends book getter
	
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}//Ends checkoutDate getter
	
	public void setDueDate(Date checkoutDate, int months) {
		this.dueDate = addMonths(checkoutDate, months);
	}//Ends dueDate setter
	
	public void setRenewalCount(int renewalCount) {
		this.renewalCount = renewalCount;
	}//Ends renewalCount setter
	
	
	public boolean renew() {
        if (renewalCount >= MAX_RENEWALS) {
            return false;
        }//Ends if statement
        dueDate = addMonths(dueDate, 3);
        renewalCount++;
        return true;
    }//Ends renew method	
	
	
	public Date addMonths(Date date, int months) {
		int newMonth = date.getMonth() + months;
        int newYear = date.getYear();

        while (newMonth > 12) {
            newMonth -= 12;
            newYear++;
        }//Ends while loop

        return new Date(newMonth, date.getDay(), newYear);
	}//Ends addMonths method
	
	public String toString() {
		return book.getTitle() + "\n" +
		"Due Date: " + dueDate + "\n" +
		"Renewal Count: " + renewalCount;
	}//Ends Loan toString
}//Ends Loan class

