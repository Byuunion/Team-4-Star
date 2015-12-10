package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FilterBox 
{
	private static String returnString;
	private static JFrame frame;
	private static String[] returnStringArray;
	static JTextField tf1;
	static JTextField tf2;
	static JTextField tf3;
	static JTextField tf4;
	static JTextField tf5;
	static JTextField tf6;


	public FilterBox()
	{
		returnString = "";
		returnStringArray = new String[6];
		for(int i = 0; i < 6; i++) 
		{
			returnStringArray[i] = "";
		}

		frame = new JFrame("Test");

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame.setSize(screenWidth, screenHeight / 2);
		frame.setLocation(screenWidth / 4, screenHeight / 4);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JLabel l1 = new JLabel("ACID: ");
		tf1 = new JTextField("");
		JLabel l2 = new JLabel("AC_NUM: ");
		tf2 = new JTextField("");
		JLabel l3 = new JLabel("Field A: ");
		tf3 = new JTextField("");
		JLabel l4 = new JLabel("Field B: ");
		tf4 = new JTextField("");
		JLabel l5 = new JLabel("Field C: ");
		tf5 = new JTextField("");
		JLabel l6 = new JLabel("Field D: ");
		tf6 = new JTextField("");

		JPanel overall = new JPanel();
		JPanel filters = new JPanel();
		JPanel buttons = new JPanel();
		overall.setLayout(new GridLayout(2,1));
		filters.setLayout(new GridLayout(6,2));
		buttons.setLayout(new GridLayout(1,2));

		JButton apply = new JButton("Apply");
		apply.addActionListener (new Action1());

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener (new Action2()); 

		filters.add(l1);
		filters.add(tf1);
		filters.add(l2);
		filters.add(tf2);
		filters.add(l3);
		filters.add(tf3);
		filters.add(l4);
		filters.add(tf4);
		filters.add(l5);
		filters.add(tf5);
		filters.add(l6);
		filters.add(tf6);

		buttons.add(apply);
		buttons.add(cancel);
		overall.add(filters);
		overall.add(buttons);

		frame.add(overall);
		frame.pack();
		frame.setVisible(true);
	}

	static class Action1 implements ActionListener 
	{    
		public void actionPerformed (ActionEvent e) 
		{     
			JFrame frame2 = new JFrame("Clicked");
			JLabel label = new JLabel("Applied Filters:");
			JLabel listOfFilters;

			returnStringArray[0] = tf1.getText();
			returnStringArray[1] = tf2.getText();
			returnStringArray[2] = tf3.getText();
			returnStringArray[3] = tf4.getText();
			returnStringArray[4] = tf5.getText();
			returnStringArray[5] = tf6.getText();
			compileString();

			if(returnString.equals(""))
			{
				listOfFilters = new JLabel("No Filters have been Applied");
			}
			else
			{	
				listOfFilters = new JLabel(getReturnString());
			}

			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(7,1));

			panel.add(label);
			panel.add(listOfFilters);
			frame2.add(panel); 
			frame2.setSize(200, 200);
			frame2.setVisible(true);
		}
	}   


	private class Action2 implements ActionListener 
	{        
		public void actionPerformed (ActionEvent e)
		{     
			frame.dispose();
		}
	}


	private static String getReturnString() 
	{
		return returnString;
	}


	public String[] getReturnStringArray() 
	{
		return returnStringArray;
	}


	private static void compileString() 
	{
		returnString = "";

		for(int i = 0; i < 6; i++) 
		{
			returnString += returnStringArray[i];
		}
	}
}
