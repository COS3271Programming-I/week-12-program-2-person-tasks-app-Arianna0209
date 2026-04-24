package week12;
import java.util.Scanner;
import java.util.InputMismatchException;

// This program allows the user to create a person and give them attributes.

class Person {
	String firstName;
	String lastName;
	String gender;
	double weight;
	String height;
	String ethnicGroup;
	String religion;

	public void print() {
		System.out.format("\nInformation about %s %s:\n", firstName, lastName);
		System.out.println("Gender: " + gender);
		System.out.println("Weight: " + weight);
		System.out.println("Height: " + height);
		System.out.println("Ethnic Group: " + ethnicGroup);
		System.out.println("Religion: " + religion);
	}
	
	public void greeting() {
		System.out.println("Hello there! How are you?");
	}
	
	public void prayer() {
		System.out.println(
			"\nOur Father, which art in heaven," +
			"\nHallowed be thy Name." +
			"\nThy kingdom come." +
			"\nThy will be done, in earth as it is in heaven." +
			"\nGive us this day our daily bread." +
			"\nAnd forgive us our trespasses," +
			"\nAs we forgive them that trespass against us." +
			"\nAnd lead us not into temptation," +
			"\nBut deliver us from evil." +
			"\nFor thine is the kingdom, The power, and the glory," +
			"\nFor ever and ever." +
			"\nAmen.");
	}
	
	public void nap() throws InterruptedException {
		System.out.println("I think it's time for me to take a rest...");
		Thread.sleep(400);
		System.out.print("\nZ");
		for (int count = 0; count <= 3; count++) {
			Thread.sleep(400);
			System.out.print("z");
		}
	}
	
	public void eat(String foodToEat) throws InterruptedException {
		System.out.println("I'm hungry, I think I'm going to eat some " + foodToEat + " now.");
		Thread.sleep(500);
		System.out.println("Yum! That was good!");
	}
	
	public String getFullName () {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	
	public String setReligion(String newReligion) {
		religion = newReligion;
		return religion;
	}
}

public class PersonTasksAPP {
	static Scanner userinput = new Scanner(System.in);
	
	// Method for trapping InputMismatchException error on integers:
	static int intTry(String message) {
		int response;
		while (true) {
			try {
				System.out.print(message);
				response = userinput.nextInt();
				userinput.nextLine();
				return response;
			} 
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid integer number (no decimal point).");
				userinput.nextLine();
				continue;
			}
		}
	}
	
	// Method for ensuring that an entered integer is between a certain range:
	static int intTryRange(String message, int start, int end) {
		int validNumber;
		while (true) {
			validNumber = intTry(message);
			if (validNumber >= start && validNumber <= end) {
				return validNumber;
			}
			else {
				System.out.format("Please enter a number between %d and %d.\n", start, end);
				continue;
			}
		}
	}
	
	// Method for trapping InputMismatchException error on doubles:
	static double doubleTry(String message) {
		double response;
		while (true) {
			try {
				System.out.print(message);
				response = userinput.nextDouble();
				userinput.nextLine();
				return response;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid number.");
				userinput.nextLine();
				continue;
			}
		}
	}
	
	// Method for ensuring that a user can only answer "yes" or "no" to a yes or no question:
	static String yesOrNo(String message) {
		String response;
		while (true) {
			System.out.print(message);
			response = userinput.nextLine();
			response = response.toLowerCase();
			if (response.equals("yes") || response.equals("no")) {
				return response;
			}
			else {
				System.out.println("Please enter \"yes\" or \"no\".\n");
				continue;
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Tell the user what the program does:
		System.out.println("This program allows you to create a person and give them attributes.");
		
		// Create a new person:
		Person person1 = new Person();
		
		// Have them enter attributes:
		System.out.println("\nEnter the following information about person 1:\n");
		System.out.print("First Name: ");
		person1.firstName = userinput.nextLine();
		System.out.print("Last Name: ");
		person1.lastName = userinput.nextLine();
		System.out.print("Gender: ");
		person1.gender = userinput.nextLine();
		person1.weight = doubleTry("Weight (lbs): ");
		System.out.print("Height (ex 5ft 5in): ");
		person1.height = userinput.nextLine();
		System.out.print("Ethnic Group: ");
		person1.ethnicGroup = userinput.nextLine();
		System.out.print("Religion: ");
		person1.religion = userinput.nextLine();
		
		// Print the person: 
		person1.print();
		
		String anotherAction = "yes";
		while (anotherAction.equals("yes")) {
			// Tell the user what they can have the person do:
			Thread.sleep(500);
			System.out.println("\nYour person can do the following things:"
					+ "\n1. Say a greeting"
					+ "\n2. Say a prayer"
					+ "\n3. Take a nap"
					+ "\n4. Eat something"
					+ "\n5. See full name"
					+ "\n6. Change their religion");
			
			// Have them choose something:
			int choice = intTryRange("Type the number of the thing you would like them to do: ", 1, 6);
			
			// Run the method that corresponds with their choice:
			if (choice == 1) {
				person1.greeting();
			}
			else if (choice == 2) {
				person1.prayer();
			}
			else if (choice == 3) {
				person1.nap();
			}
			else if (choice == 4) {
				System.out.println("What food would you like your person to eat? ");
				String food = userinput.nextLine();
				person1.eat(food);
			}
			else if (choice == 5) {
				System.out.println("Your person's full name is " + person1.getFullName()); 
			}
			else if (choice == 6) {
				System.out.println("What would you like to change your person's religion to? ");
				String changedReligion = userinput.nextLine();
				person1.setReligion(changedReligion);
			}
			
			// Ask the user if they would like to perform another task:
			anotherAction = yesOrNo("Would you like to perform another task? Enter \"yes\" or \"no\": ");
		}
	
		// If the user ends the program, let them know:
		System.out.println("Program Ended.");
	}

}
