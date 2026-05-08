package libraryCatalogPackage;

public class Name {
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}//Ends first/last Name constructor
	
	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}//Ends first/middle/last Name constructor

	public String getFirstName() {
		return firstName;
	}//Ends firstName getter

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}//Ends firstName setter

	public String getMiddleName() {
		return middleName;
	}//Ends middleName getter

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}//Ends middleName setter

	public String getLastName() {
		return lastName;
	}//Ends lastName getter

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}//Ends lastName getter
	
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}//Ends Name toString
	
}//Ends Name class