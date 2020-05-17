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
	 * @author Dennis Myers
	 * @param runs Integer value of runs to be made before decision made.
	 */
	public void multiDecision(int runs){
		for(int i = 0; i < runs; i++){
			options.get(ran.nextInt(numOptions)).increment();
		}
		showResults();
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
				numOptions--;
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
	 */
	public void showResults(){
		System.out.println("\nResults of Decion Maker :");
		int max = 0;
		int i = 1;
		String winner = "";
		for(Option o : options){
			System.out.println("\t" + i + " : " + o.getNumTimes() + " - " + o.getText());
			if(o.getNumTimes() > max){
				max = o.getNumTimes();
				winner = o.getText();
			}
			i++;
		}
		System.out.println("\n" + winner + " wins with " + max + " votes!\n");
	}

	public void clearOptions(){
		options.clear();
		numOptions = 0;
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
