package DecisionMaker;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Insets;
import java.lang.Double;

/**
 * Class to contain interface for DecisionMaker functionality.
 * @author Dennis Myers
 */
public class DecisionMain{

	private JFrame f;
	private JButton bAddRow,bClearTb,bUpdate;
	private JTable tb;
	private Dimension screensize;
	private int width, height, count;
	private Insets fInsets;
	private OptionHandler oh;
	private DefaultTableModel model;

	/**
	 * Constructor for DecisionMain.
	 * @author Dennis Myers
	 */
	DecisionMain(){
		oh = new OptionHandler();
		count = 2;
		getInfo();
		initializeComponents();
		setComponents();
		addComponents();
		finalizeFrame();
		setListeners();
	}

	public void getInfo(){
		screensize = Toolkit.getDefaultToolkit().getScreenSize();
		width = new Double(screensize.getWidth()).intValue()/2;
		height = new Double(screensize.getHeight()).intValue()/2;
	}

	/**
	 * Method to initialize JComponents.
	 * @author Dennis Myers
	 */
	public void initializeComponents(){
		f = new JFrame("Decision Maker");
		bAddRow = new JButton("+ Row");
		bClearTb = new JButton("Clear Choices");
		bUpdate = new JButton("Update Choices");
		model = new DefaultTableModel();
		tb = new JTable(model);
	}

	/**
	 * Method to set attributes of JComponents.
	 * @author Dennis Myers
	 */
	public void setComponents(){
		model.addColumn("#");
		model.addColumn("Choice");
		model.addRow(new Object[]{1,""});
		tb.setBounds(20,30,(width/2)-20,height-150);
		tb.setRowHeight(tb.getHeight()/10);

		bClearTb.setBounds(20,height-100,((width/2)/3)-20,40);
		bAddRow.setBounds(((width/2)/3)+20,height-100,((width/2)/3)-20,40);
		bUpdate.setBounds(((width)/3)+20,height-100,((width/2)/3)-20,40);
	}

	/**
	 * Method to add JComponents to JFrame.
	 * @author Dennis Myers
	 */
	public void addComponents(){
		f.add(tb);
		f.add(bClearTb);
		f.add(bAddRow);
		f.add(bUpdate);
	}

	/**
	 * Method to set attributes of JFrame.
	 * @author Dennis Myers
	 */
	public void finalizeFrame(){
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setMinimumSize(new Dimension(width,height));
	}

	/**
	 * Method to set ActionListeners of necessary JComponents.
	 * @author Dennis Myers
	 */
	public void setListeners(){
		bAddRow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.addRow(new Object[]{count,""});
				count++;
			}
		});

		bClearTb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model = new DefaultTableModel();
				model.addColumn("#");
				model.addColumn("Choice");
				model.addRow(new Object[]{1,""});
				tb.setModel(model);
				count = 2;
			}
		});
	}

	/**
	 * Main function.
	 * @author Dennis Myers
	 */
	public static void main(String[] args){
		new DecisionMain();
	}
}
