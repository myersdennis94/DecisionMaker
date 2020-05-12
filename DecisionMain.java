package DecisionMaker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.Scanner;
import java.lang.NumberFormatException;

/**
 * Class to contain interface for DecisionMaker functionality.
 * @author Dennis Myers
 */
public class DecisionMain{

	private JFrame f;

	/**
	 * Constructor for DecisionMain.
	 * @author Dennis Myers
	 */
	DecisionMain(){
		initializeComponents();
		setComponents();
		addComponents();
		finalizeFrame();
		setListeners();
	}

	/**
	 * Method to initialize JComponents.
	 * @author Dennis Myers
	 */
	public void initializeComponents(){
		f = new JFrame("Decision Maker");

	}

	/**
	 * Method to set attributes of JComponents.
	 * @author Dennis Myers
	 */
	public void setComponents(){

	}

	/**
	 * Method to add JComponents to JFrame.
	 * @author Dennis Myers
	 */
	public void addComponents(){

	}

	/**
	 * Method to set attributes of JFrame.
	 * @author Dennis Myers
	 */
	public void finalizeFrame(){
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setMinimumSize(new Dimension(400,400));
	}

	/**
	 * Method to set ActionListeners of necessary JComponents.
	 * @author Dennis Myers
	 */
	public void setListeners(){

	}

	/**
	 * Main function.
	 * @author Dennis Myers
	 */
	public static void main(String[] args){
		new DecisionMain();
	}
}
