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
	static JTextField acidl;
	static JTextField st_timel;
	static JTextField end_timel;
	static JTextField ac_eql;
	static JTextField ac_typel;
	static JTextField origin_fixl;
	static JTextField start_centerl;
	static JTextField avg_climbl;


	public FilterBox()
	{
		returnString = "";
		returnStringArray = new String[8];
		for(int i = 0; i < 8; i++) 
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

		JLabel l1 = new JLabel("acid: ");
		acidl = new JTextField("");
		JLabel l2 = new JLabel("st_time: ");
		st_timel = new JTextField("");
		JLabel l3 = new JLabel("end_time: ");
		end_timel = new JTextField("");
		JLabel l4 = new JLabel("ac_eq: ");
		ac_eql = new JTextField("");
		JLabel l5 = new JLabel("ac_type: ");
		ac_typel = new JTextField("");
		JLabel l6 = new JLabel("origin_fix: ");
		origin_fixl = new JTextField("");
		JLabel l7 = new JLabel("start_center: ");
		start_centerl = new JTextField("");
		JLabel l8 = new JLabel("avg_climb: ");
		avg_climbl = new JTextField("");

		JPanel overall = new JPanel();
		JPanel filters = new JPanel();
		JPanel buttons = new JPanel();
		overall.setLayout(new GridLayout(2,1));
		filters.setLayout(new GridLayout(8,2));
		buttons.setLayout(new GridLayout(1,2));

		JButton apply = new JButton("Apply");
		apply.addActionListener (new Action1());

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener (new Action2()); 

		filters.add(l1);
		filters.add(acidl);
		filters.add(l2);
		filters.add(st_timel);
		filters.add(l3);
		filters.add(end_timel);
		filters.add(l4);
		filters.add(ac_eql);
		filters.add(l5);
		filters.add(ac_typel);
		filters.add(l6);
		filters.add(origin_fixl);
		filters.add(l7);
		filters.add(start_centerl);
		filters.add(l8);
		filters.add(avg_climbl);
		

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

			returnStringArray[0] = acidl.getText();
			returnStringArray[1] = st_timel.getText();
			returnStringArray[2] = end_timel.getText();
			returnStringArray[3] = ac_eql.getText();
			returnStringArray[4] = ac_typel.getText();
			returnStringArray[5] = origin_fixl.getText();
			returnStringArray[6] = start_centerl.getText();
			returnStringArray[7] = avg_climbl.getText();
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

		for(int i = 0; i < 8; i++) 
		{
			returnString += returnStringArray[i];
		}
	}
}
