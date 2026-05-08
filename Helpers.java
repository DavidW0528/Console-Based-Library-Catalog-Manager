package libraryCatalogPackage;

import java.util.*;
import java.time.*;

//This is a class of reusable helper methods for console-based programs

public class Helpers {

	public static void billboard(String text) {
		String middle = "== " + text + " ==";
		String border = "";
		//Repeats '=' for each character in the text
		for(int i = 0; i < middle.length(); i++) {
			border += "=";
		}//Ends for
		//Prints the bordered text
		System.out.println(border);
		System.out.println(middle);
		System.out.println(border);
	}//Ends billboard() method
	
	
	public static void clearConsole() {
		//Prints 30 blank lines
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}//Ends for
	}//Ends clearConsole() method
	
	
	public static void pause(Scanner scanner) {
		System.out.print("Press ENTER to continue...");
		scanner.nextLine();
	}//Ends pause() method
	
	
	public static Date getCurrentDate() {
		LocalDate now = LocalDate.now();
		return new Date(now.getMonthValue(), now.getDayOfMonth(), now.getYear());
	}//Ends currentDate getter
}//Ends Helpers class
