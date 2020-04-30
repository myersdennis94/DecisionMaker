package DecisionMaker;

import java.util.ArrayList;

/**
 * Class to manage multiple options and their functionality.
 * @author Dennis Myers
 */
public class OptionHandler{
	private int numOptions;
	private ArrayList <Option> options;

	/**
	 * Method to hold functionality for single decision.
	 * @author 
	 */
	public void oneDecision(){

	}

	/**
	 * Method to hold functionality for multiple runs before decision.
	 * @author
	 * @param runs Integer value of runs to be made before decision made.
	 */
	public void multiDecision(int runs){

	}

	/**
	 * Method to add Option to options ArrayList.
	 * @author
	 * @param s String choice to create Option with.
	 */
	public void addOption(String s){
		Option o = new Option(s);
		options.add(o);
		numOptions++;
	}

	public void showOptions(){
		int i = 1;
		for(Option temp : options){
			System.out.println("\t" + i + " : " + temp.getText());
			i++;
		}
	}

	/**
	 * Constructor for OptionHandler class.
	 * @author Dennis Myers
	 */
	OptionHandler(){
		numOptions = 0;
		options = new ArrayList<Option>();
	}
}