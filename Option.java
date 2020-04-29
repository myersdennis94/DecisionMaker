package DecisionMaker;

public class Option{
	private String text;
	private int numTimes = 0;

	Option(String text){
		this.text = text;
	}

	public void increment(){
		numTimes++;
	}

	public String getText(){
		return text;
	}
}