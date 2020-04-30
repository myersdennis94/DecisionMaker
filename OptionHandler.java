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
	 * @param o Option object to be added to options ArrayList.
	 */
	public void addOption(Option o){
		options.add(o);
		numOptions++;
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