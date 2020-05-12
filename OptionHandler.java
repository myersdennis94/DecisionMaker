package DecisionMaker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class to manage multiple options and their functionality.
 * @author Dennis Myers
 */
public class OptionHandler{
	private int numOptions;
	private ArrayList <Option> options;
	private Random ran;

	/**
	 * Method to hold functionality for multiple runs before decision.
	 * Creates int array to hold counts. Uses random function to counts
	 * within number of option bounds.
	 * @author Dennis Myers
	 * @param runs Integer value of runs to be made before decision made.
	 */
	public void multiDecision(int runs){
		int[] count = new int[options.size()];
		for(int i = 0; i < runs; i++){
			count[ran.nextInt(options.size())]++;
		}
		showResults(count);
	}

	/**
	 * Method to add Option to options ArrayList.
	 * @author Dennis Myers
	 * @param s String choice to create Option with.
	 */
	public void addOption(String s){
		Option o = new Option(s);
		options.add(o);
		numOptions++;
	}

	/**
	 * Method to remove option from a options list
	 * @author Dennis Myers
	 * @param s String value of option to search for and remove
	 * @return String of success or failure
	 */
	public String removeOption(String s){
		boolean found = false;
		for(Option temp : options){
			if(temp.getText().equals(s)){
				options.remove(temp);
				found = true;
				break;
			}
		}
		if(found == true){
			return "Option successfully removed.";
		}else{
			return "Option not found.";
		}
	}

	/**
	 * Method to print available options
	 * @author Dennis Myers
	 */
	public void showOptions(){
		int i = 1;
		for(Option temp : options){
			System.out.println("\t" + i + " : " + temp.getText());
			i++;
		}
	}

	/**
	 * Method to get numOptions field value
	 * @author Dennis Myers
	 * @return int value of numOptions
	 */
	public int getNumOptions(){
		return numOptions;
	}

	/**
	 * Method to print results of decision making.
	 * @author Dennis Myers
	 * @param arr Integer array of counts from multiDecision.
	 */
	public void showResults(int[] arr){
		System.out.println("\nResults of Decion Maker :");
		int max = 0;
		String winner = "";
		for(int i = 0; i < options.size(); i++){
			System.out.println("\t" + (i + 1) + " : " + arr[i] + " - " + options.get(i).getText());
			if(arr[i] > max){
				max = arr[i];
				winner = options.get(i).getText();
			}
		}
		System.out.println("\n" + winner + " wins with " + max + " votes!\n");
	}

	/**
	 * Constructor for OptionHandler class.
	 * @author Dennis Myers
	 */
	OptionHandler(){
		numOptions = 0;
		options = new ArrayList<Option>();
		ran = new Random(System.currentTimeMillis());
	}
}
