package ui;

import java.awt.*;
import javax.swing.*;


public class UIScreen extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private InformationPanel dataPanel;
	private ButtonPanel buttons;
	private JButton visualize;
	private FilterPanel filterPanel;


	public UIScreen() 
	{
		super("Flight Pattern Analyzer Ver_1.0.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();


		dataPanel = new InformationPanel();

		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.NORTHWEST;
		con.gridx = 2;
		con.gridy = 0;
		con.weightx = 2;
		con.weighty = 1;
		con.gridwidth = 1;
		con.gridheight = 2;
		con.ipadx = 200;
		con.ipady = 0;

		add(dataPanel, con);



		buttons = new ButtonPanel();
		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.NORTHEAST;
		con.gridx = 0;
		con.gridy = 0;
		con.weightx = 0.5;
		con.weighty = 0.5;
		con.gridwidth = 1;
		con.gridheight = 1;
		con.ipadx = 0;
		con.ipady = 0;

		add(buttons, con);

		
		
		filterPanel = new FilterPanel();
		
		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.SOUTHWEST;
		con.gridx = 0;
		con.gridy = 1;
		con.weightx = 0.5;
		con.weighty = 0.5;
		con.gridwidth = 1;
		con.gridheight = 1;
		con.ipadx = 0;
		con.ipady = 0;
		
		add(filterPanel, con);
		


		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenu menu2= new JMenu("Options");				
		menubar.add(menu1);
		menubar.add(menu2);
		setJMenuBar(menubar);
		
		
		
		pack();
		setSize(1200, 900);
		setVisible(true);
	}


	public JButton getVisualizer()
	{
		return visualize;
	}


	public ButtonPanel getButtonPanel()
	{
		return buttons;
	}


	public InformationPanel getInfoPanel()
	{
		return dataPanel;
	}


	public FilterPanel getFilterPanel() 
	{
		return filterPanel;
	}

}
