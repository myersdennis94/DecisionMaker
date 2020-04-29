package DecisionMaker;

public class OptionHandler{
	private int numOptions;
	private ArrayList <Option> options;

	public void oneDecision(){

	}

	public void multiDecision(int runs){

	}

	public void addOption(Option o){
		options.add(o);
		numOptions++;
	}

	OptionHandler(){
		numOptions = 0;
		options = new ArrayList<Options>();
	}
}