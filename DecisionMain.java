package DecisionMaker;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class to contain general functionality for DecisionMaker. Creation of
 * relevant objects, menu printing, UI handling.
 * @author Dennis Myers
 */
public class DecisionMain{

	/**
	 * Method to print menu options.
	 * @author Dennis Myers
	 */
	public static void printMenu(){
		System.out.println("Decision Maker Program Options :");
		System.out.println("\t1. Enter new option");
		System.out.println("\t2. Erase existing option");
		System.out.println("\t3. Run Decision Maker");
		System.out.println("\t4. Exit program");
	}

	/**
	 * Main function.
	 * @author Dennis Myers
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int response;

		System.out.println("Welcome to Decision Maker!");
		System.out.println("\nThe purpose of this program is to help you pick between different items.");
		System.out.println("Enter some options to choose from and then run Decision Maker!\n");

		while(true){
			printMenu();
			System.out.print(">");
			try{
				response = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nInvalid input. Input must be an integer value.\n");
				sc.next();
				continue;
			}
			switch(response){
				case 1:
					System.out.println("\nIn enter option\n");
					break;
				case 2:
					System.out.println("\nIn erase option\n");
					break;
				case 3:
					System.out.println("\nIn run decision maker\n");
					break;
				case 4:
					System.out.println("\nExiting program.");
					System.out.println("Have a nice day!\n");
					return;
				default:
					System.out.println("\nInvalid input. Input must match one of listed values.\n");
			}
		}
	}
}