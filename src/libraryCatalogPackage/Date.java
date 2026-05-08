package libraryCatalogPackage;

public class Date {
	
	private int month; //(1-12)
	private int day; //(1-31)
	private int year; //(1900-2026)
	
	public Date() {
		this(1, 1, 2000);
	}//Ends Date constructor method with no arguments
	
    public Date(int month, int day, int year) {
        if (!isValidDate(month, day, year)) {
            throw new IllegalArgumentException("Invalid date.");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }//Ends Date constructor method
	    
    
    public int getMonth() {
    	return month;
    }//Ends month getter
    
    public int getDay() {
    	return day;
    }//Ends day getter
    
    public int getYear() {
    	return year;
    }//Ends year getter
    
	public void setMonth(int newMonth) {
        // Propose (newMonth, current day, current year)
        if (!isValidDate(newMonth, this.day, this.year)) {
            throw new IllegalArgumentException("Invalid month for current day/year.");
        }
        this.month = newMonth;
    }//Ends setMonth setter method

	public void setDay(int newDay) {
        // Check if the format is valid (current month, newDay, current year)
        if (!isValidDate(this.month, newDay, this.year)) {
            throw new IllegalArgumentException("Invalid day for current month/year.");
        }//Ends if statement
        this.day = newDay;
    }//Ends setDay setter method

    public void setYear(int newYear) {
        // Checks if the format is valid (current month, current day, newYear) - handles leap-years on Feb 29
        if (!isValidDate(this.month, this.day, newYear)) {
            throw new IllegalArgumentException("Invalid year for current month/day (leap-year rule).");
        	}//Ends if-statement
        }//Ends setYear setter method

    public void setDate(int newMonth, int newDay, int newYear) {
        if (!isValidDate(newMonth, newDay, newYear)) {
            throw new IllegalArgumentException("Invalid date.");
        }
        this.month = newMonth;
        this.day = newDay;
        this.year = newYear;
    }//Ends setDate setter method


    private boolean isValidDate(int month, int day, int year) {
        if (month < 1 || month > 12) return false;
        if (day < 1) return false;

        int max = daysInMonth(month, year);
        return day <= max;
    }//Ends isValidDate method

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 2:  return isLeapYear(year) ? 29 : 28; // February (handles leap years)
            case 4:
            case 6:
            case 9:
            case 11: return 30; // Apr, Jun, Sep, Nov
            default: return 31; // Jan, Mar, May, Jul, Aug, Oct, Dec
        }//Ends switch/case
    }//Ends daysInMonth method

     //Leap-year rule: divisible by 4 AND (not by 100 unless also by 400)
     private boolean isLeapYear(int y) {
         return (y % 4 == 0) && ((y % 100 != 0) || (y % 400 == 0));
     } //Ends isLeapYear method
     

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }//Ends toString

}//Ends Date class