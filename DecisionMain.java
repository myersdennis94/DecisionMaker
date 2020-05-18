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
	private JButton bAddRow,bClearTb,bUpdate,bRun,bRet;
	private JTable tb,tbs;
	private JTextArea t;
	private JTextPane i;
	private JScrollPane sc;
	private Dimension screensize;
	private int width, height, count;
	private OptionHandler oh;
	private DefaultTableModel model,statModel;
	private boolean initialized;
	private final String IMAGE_SRC = DecisionMain.class.getResource("/images/logo.png").toString();

	/**
	 * Constructor for DecisionMain.
	 * @author Dennis Myers
	 */
	DecisionMain(){
		oh = new OptionHandler();
		count = 2;
		initialized = false;
		getInfo();
		initializeComponents();
		setComponents();
		addComponents();
		finalizeFrame();
		setListeners();
	}

	/**
	 * Method to get information about user screen size.
	 * @author Dennis Myers
	 */
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
		bRet = new JButton();
		bRun = new JButton("Run Decision Maker");
		t = new JTextArea("Hello!");
		i = new JTextPane();
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
		statModel = new DefaultTableModel();
		tbs = new JTable(statModel);
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
		tbs.setCellSelectionEnabled(false);

		t.setBounds((width/2)+40,30,(width/2)-100,(height/2)-40);
		bClearTb.setBounds(20,height-100,((width/2)/3)-20,40);
		bAddRow.setBounds(((width/2)/3)+20,height-100,((width/2)/3)-20,40);
		bUpdate.setBounds(((width)/3)+20,height-100,((width/2)/3)-20,40);
		bRun.setBounds((width/2)+60,(height/2)+10,(width/2)-140,40);
		bRet.setBounds((width/2)+60,(height/2)+70,(width/2)-140,40);
		bRet.setVisible(false);

		i.setBounds((width/2)+60,(height/2)+130,200,200);
		i.setContentType("text/html");
		i.setText("<html><img src=" + IMAGE_SRC + "width=200 height=100></img><p>Dennis Myers - 2020</p></html>");
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
		f.add(bRet);
		f.add(t);
		f.add(i);
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

		// action handling of + Row button
		bAddRow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.addRow(new Object[]{count,""});
				count++;
			}
		});

		// action handling of Clear Choices button
		bClearTb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model = new DefaultTableModel();
				model.addColumn("#");
				model.addColumn("Choice");
				model.addRow(new Object[]{1,""});
				tb.setModel(model);
				count = 2;
				oh.clearOptions();
				sc.setViewportView(tb);
				statModel = new DefaultTableModel();
				tbs.setModel(statModel);
				initialized = false;
				bRet.setVisible(false);
			}
		});

		// action handling of Update Choices button
		bUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(tb.getSelectedRow() != -1){
					tb.getCellEditor().stopCellEditing();
				}
				oh.clearOptions();
				sc.setViewportView(tb);
				statModel = new DefaultTableModel();
				tbs.setModel(statModel);
				initialized = false;
				bRet.setVisible(false);
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
				if(tb.getRowCount() == 0){
					model.addRow(new Object[]{1,""});
				}
			}
		});

		// action handling of Run Decision Maker button
		bRun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(oh.getNumOptions() < 2){
					JOptionPane.showMessageDialog(f,"Not enough choices loaded.","Error",JOptionPane.WARNING_MESSAGE);
				}else{
					String reply = JOptionPane.showInputDialog(f,"Enter the number of trials.","Trail Selector",JOptionPane.INFORMATION_MESSAGE);
					if(reply == null){
						JOptionPane.showMessageDialog(f,"Decision Maker cancelled.","Warning",JOptionPane.WARNING_MESSAGE);
					}else if(!reply.matches("-?(0|[1-9]\\d*)")){
						JOptionPane.showMessageDialog(f,"Trail count must be integer value greater than 0.","Warning",JOptionPane.WARNING_MESSAGE);
					}else{
						if(Integer.parseInt(reply) < 1){
							JOptionPane.showMessageDialog(f,"Trail count must be integer value greater than 0.","Warning",JOptionPane.WARNING_MESSAGE);
						}else{
							if(initialized == false){
								setupStatModel();
							}
							oh.multiDecision(Integer.parseInt(reply));
							oh.generateStatTable(statModel,false);
							t.append("\nWinner was : " + oh.getWinner());
							JOptionPane.showMessageDialog(f,"Decision made successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
							sc.setViewportView(tbs);
							bRet.setText("Return to Choices");
							bRet.setVisible(true);
						}
					}
				}
			}
		});

		bRet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(bRet.getText() == "Return to Choices"){
					sc.setViewportView(tb);
					bRet.setText("Return to Statistics");
				}else{
					sc.setViewportView(tbs);
					bRet.setText("Return to Choices");
				}
			}
		});
	}

	public void setupStatModel(){
		statModel.addColumn("#");
		statModel.addColumn("Choice");
		statModel.addColumn("Last Run Picks");
		statModel.addColumn("Total Run Picks");
		oh.generateStatTable(statModel,true);
		initialized = true;
	}

	/**
	 * Main function.
	 * @author Dennis Myers
	 */
	public static void main(String[] args){
		new DecisionMain();
	}
}
