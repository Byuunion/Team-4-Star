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
	private static JFrame frame;
	private static String returnString;
	private static String ACID;
	


	private static String ST_TIME;
	private static String END_TIME;
	private static String AC_EQ;
	private static String AC_TYPE;
	private static String ORIGIN_FIX;
	private static String START_CENTER;
	private static String AVG_CLIMB;
	static JTextField acid;
	static JTextField st_time;
	static JTextField end_time;
	static JTextField ac_eq;
	static JTextField ac_type;
	static JTextField origin_fix;
	static JTextField start_center;
	static JTextField avg_climb;


	public FilterBox(){
		returnString = "";
		String ACID = "";
		String ST_TIME = "";
		String END_TIME = "";
		String AC_EQ = "";
		String AC_TYPE = "";
		String ORIGIN_FIX = "";
		String START_CENTER = "";
		String AVG_CLIMB = "";
		
		frame = new JFrame("Test");

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame.setSize(screenWidth, screenHeight / 2);
		frame.setLocation(screenWidth / 4, screenHeight / 4);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JLabel l1 = new JLabel("acid: ");
		acid = new JTextField("");
		JLabel l2 = new JLabel("st_time: ");
		st_time = new JTextField("");
		JLabel l3 = new JLabel("end_time: ");
		end_time = new JTextField("");
		JLabel l4 = new JLabel("ac_eq: ");
		ac_eq = new JTextField("");
		JLabel l5 = new JLabel("ac_type: ");
		ac_type = new JTextField("");
		JLabel l6 = new JLabel("origin_fix: ");
		origin_fix = new JTextField("");
		JLabel l7 = new JLabel("start_center: ");
		start_center = new JTextField("");
		JLabel l8 = new JLabel("avg_climb: ");
		avg_climb = new JTextField("");

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
		filters.add(acid);
		filters.add(l2);
		filters.add(st_time);
		filters.add(l3);
		filters.add(end_time);
		filters.add(l4);
		filters.add(ac_eq);
		filters.add(l5);
		filters.add(ac_type);
		filters.add(l6);
		filters.add(origin_fix);
		filters.add(l7);
		filters.add(start_center);
		filters.add(l8);
		filters.add(avg_climb);

		buttons.add(apply);
		buttons.add(cancel);
		overall.add(filters);
		overall.add(buttons);

		frame.add(overall);
		frame.pack();
		frame.setVisible(true);
	}

	static class Action1 implements ActionListener {    
		public void actionPerformed (ActionEvent e) {     
			JFrame frame2 = new JFrame("Clicked");
			JLabel label = new JLabel("Applied Filters:");
			JLabel listOfFilters;

			ACID = acid.getText();
			ST_TIME = st_time.getText();
			END_TIME = end_time.getText();
			AC_EQ = ac_eq.getText();
			AC_TYPE = ac_type.getText();
			ORIGIN_FIX = origin_fix.getText();
			START_CENTER = start_center.getText();
			AVG_CLIMB = avg_climb.getText();

			if(returnString.equals("")){
				listOfFilters = new JLabel("No Filters have been Applied");
			}
			else{	
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


	private class Action2 implements ActionListener {        
		public void actionPerformed (ActionEvent e){     
			frame.dispose();
		}
	}

	public static String getReturnString() 
	{
		return returnString;
	}
	
	public static String getACID() {
		return ACID;
	}

	public static void setACID(String aCID) {
		ACID = aCID;

	}

	public static String getST_TIME() {
		return ST_TIME;
	}


	public static void setST_TIME(String sT_TIME) {
		ST_TIME = sT_TIME;
	}


	public static String getEND_TIME() {
		return END_TIME;
	}


	public static void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}


	public static String getAC_EQ() {
		return AC_EQ;
	}


	public static void setAC_EQ(String aC_EQ) {
		AC_EQ = aC_EQ;
	}


	public static String getAC_TYPE() {
		return AC_TYPE;
	}


	public static void setAC_TYPE(String aC_TYPE) {
		AC_TYPE = aC_TYPE;
	}


	public static String getORIGIN_FIX() {
		return ORIGIN_FIX;
	}


	public static void setORIGIN_FIX(String oRIGIN_FIX) {
		ORIGIN_FIX = oRIGIN_FIX;
	}


	public static String getSTART_CENTER() {
		return START_CENTER;
	}


	public static void setSTART_CENTER(String sTART_CENTER) {
		START_CENTER = sTART_CENTER;
	}


	public static String getAVG_CLIMB() {
		return AVG_CLIMB;
	}


	public static void setAVG_CLIMB(String aVG_CLIMB) {
		AVG_CLIMB = aVG_CLIMB;
	}
	
	public String[] getReturnStringArray(){
		return null;
	}

}