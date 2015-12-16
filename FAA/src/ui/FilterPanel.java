package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class FilterPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	String[] filterChoices;
	static JTextField acid;
	static JTextField st_time;
	static JTextField end_time;
	static JTextField ac_eq;
	static JTextField ac_type;
	static JTextField origin_fix;
	static JTextField start_center;
	static JTextField avg_climb;
	private JButton apply;
	private JButton cancel;


	public FilterPanel()
	{
		filterChoices = new String[8];
	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width, screenSize.height / 2);
		setLocation(screenSize.width / 4, screenSize.height / 4);

		JLabel l1 = new JLabel("ACID:");
		acid = new JTextField("");
		JLabel l2 = new JLabel("ST_TIME:");
		st_time = new JTextField("");
		JLabel l3 = new JLabel("END_TIME:");
		end_time = new JTextField("");
		JLabel l4 = new JLabel("AC_EQ:");
		ac_eq = new JTextField("");
		JLabel l5 = new JLabel("AC_TYPE:");
		ac_type = new JTextField("");
		JLabel l6 = new JLabel("ORIGIN_FIX:");
		origin_fix = new JTextField("");
		JLabel l7 = new JLabel("STAR_CENTER:");
		start_center = new JTextField("");
		JLabel l8 = new JLabel("AVG_CLIMB:");
		avg_climb = new JTextField("");

		JPanel overall = new JPanel();
		JPanel filters = new JPanel();
		JPanel buttons = new JPanel();
		overall.setLayout(new GridLayout(2,1));
		filters.setLayout(new GridLayout(8,2));
		buttons.setLayout(new GridLayout(1,2));

		apply = new JButton("Apply");

		cancel = new JButton("Clear");
		cancel.addActionListener(new clearAction()); 

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

		acid.setPreferredSize(new Dimension(200, 24));
		
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		l7.setHorizontalAlignment(SwingConstants.CENTER);
		l8.setHorizontalAlignment(SwingConstants.CENTER);
		
		apply.setEnabled(false);
		cancel.setEnabled(false);
		
		
		add(overall);
		TitledBorder border = BorderFactory.createTitledBorder("Apply Filters");
		border.setTitleJustification(TitledBorder.CENTER);
		setBorder(border);
		setVisible(true);
	}


	private class clearAction implements ActionListener 
	{        
		public void actionPerformed(ActionEvent e)
		{     
			acid.setText("");
			st_time.setText("");
			end_time.setText("");
			ac_eq.setText("");
			ac_type.setText("");
			origin_fix.setText("");
			start_center.setText("");
			avg_climb.setText("");
			setFilters();
		}
		
	}
	
	
	public void enableButtons()
	{
		apply.setEnabled(true);
		cancel.setEnabled(true);
	}

	
	public void setFilters()
	{
		filterChoices[0] = acid.getText();
		filterChoices[1] = st_time.getText();
		filterChoices[2] = end_time.getText();
		filterChoices[3] = ac_eq.getText();
		filterChoices[4] = ac_type.getText();
		filterChoices[5] = origin_fix.getText();
		filterChoices[6] = start_center.getText();
		filterChoices[7] = avg_climb.getText();
	}
	
	
	public String[] getFilters()
	{
		return filterChoices;
	}

	
	public JButton getApplyButton()
	{
		return apply;
	}

}
