package DecisionMaker;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.Double;

/**
 * Class to contain interface for DecisionMaker functionality.
 * @author Dennis Myers
 */
public class DecisionMain{

	private JFrame f;
	private JButton bAddRow,bClearTb,bUpdate,bRun;
	private JTable tb;
	private JTextArea t;
	private JScrollPane sc;
	private Dimension screensize;
	private int width, height, count;
	private OptionHandler oh;
	private DefaultTableModel model,statModel;

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
		bRun = new JButton("Run Decision Maker");
		t = new JTextArea("Hello!");
		sc = new JScrollPane();
		model = new DefaultTableModel();
		tb = new JTable(model){
			public boolean isCellEditable(int row, int column){
				if(column == 0){
					return false;
				}else{
					return true;
				}
			}

			public boolean isCellSelected(int row, int column){
				if(column == 0){
					return false;
				}else{
					if(row == tb.getSelectedRow() && column == tb.getSelectedColumn()){
						return true;
					}else{
						return false;
					}
				}
			}
		};
	}

	/**
	 * Method to set attributes of JComponents.
	 * @author Dennis Myers
	 */
	public void setComponents(){
		model.addColumn("#");
		model.addColumn("Choice");
		model.addRow(new Object[]{1,""});
		sc.setBounds(20,30,(width/2)-20,height-150);
		sc.setViewportView(tb);
		tb.setRowHeight(sc.getHeight()/10);
		tb.setSelectionBackground(Color.white);

		t.setBounds((width/2)+40,30,(width/2)-100,(height/2)-40);
		bClearTb.setBounds(20,height-100,((width/2)/3)-20,40);
		bAddRow.setBounds(((width/2)/3)+20,height-100,((width/2)/3)-20,40);
		bUpdate.setBounds(((width)/3)+20,height-100,((width/2)/3)-20,40);
		bRun.setBounds((width/2)+60,(height/2)+20,(width/2)-140,(height/4)-20);
	}

	/**
	 * Method to add JComponents to JFrame.
	 * @author Dennis Myers
	 */
	public void addComponents(){
		f.add(sc);
		f.add(bClearTb);
		f.add(bAddRow);
		f.add(bUpdate);
		f.add(bRun);
		f.add(t);
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
				oh.clearOptions();
			}
		});

		bUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				oh.clearOptions();
				for(int i = 0; i < model.getRowCount(); i++){
					if(model.getValueAt(i,1).toString().equals("")){
						model.removeRow(i);
						for(int j = i; j < model.getRowCount(); j++){
							model.setValueAt(j+1,j,0);
						}
						i--;
					}else{
						oh.addOption(model.getValueAt(i,1).toString());
					}
				}
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
