package DecisionMaker;

/**
 * Option class to hold option information and stats.
 * @author Dennis Myers
 */
public class Option{
	private String text;
	private int numTimes = 0;

	/**
	 * Constructor for Option object.
	 * @author Dennis Myers
	 * @param text String representation of option.
	 */
	Option(String text){
		this.text = text;
	}

	/**
	 * Incrementer for numTimes.
	 * @author Dennis Myers
	 */
	public void increment(){
		numTimes++;
	}

	/**
	 * Method to return class field text.
	 * @author Dennis Myers
	 * @return Class field text.
	 */
	public String getText(){
		return text;
	}

	/**
	 * Method to return number of times chosen.
	 * @author
	 * @return Number of times chosen.
	 */
	 public int getNumTimes(){
		 return numTimes;
	 }
}
