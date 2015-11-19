package Mark1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class UI_Screen extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private InformationPanel dataPanel;
	private JPanel variablePane;

	public UI_Screen() 
	{
		super("Flight Pattern Analyzer Ver_0.0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();




		variablePane = new JPanel(new GridLayout(4, 2));
		variablePane.setBorder(BorderFactory.createTitledBorder(null, "Pattern Variables", TitledBorder.CENTER, DISPOSE_ON_CLOSE));
		JButton time = new JButton("Time");
		variablePane.add(time);
		time.addActionListener(new TimeButtonListener());
		JButton weight = new JButton("Weight");
		weight.addActionListener(new WeightButtonListener());
		variablePane.add(weight);
		JButton airline = new JButton("Airline");
		airline.addActionListener(new AirlineButtonListener());
		variablePane.add(airline);
		JButton a = new JButton("Climb Rate");
		variablePane.add(a);
		JButton b = new JButton("Airport");
		variablePane.add(b);
		JButton c = new JButton("Passengers");
		variablePane.add(c);
		JButton d = new JButton("Airplane");
		variablePane.add(d);
		JButton e = new JButton("Fuel");
		variablePane.add(e);

		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.NORTHWEST;
		con.gridx = 0;
		con.gridy = 0;
		con.weightx = 0.8;
		con.weighty = 1;
		con.gridwidth = 1;
		con.gridheight = 2;
		con.ipadx = 0;
		con.ipady = 0;

		setVarPaneFalse();
		variablePane.isOpaque();
		add(variablePane, con);




		dataPanel = new InformationPanel();

		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.NORTHEAST;
		con.gridx = 2;
		con.gridy = 0;
		con.weightx = 1;
		con.weighty = 1;
		con.gridwidth = 2;
		con.gridheight = 3;
		con.ipadx = 200;
		con.ipady = 0;


		add(dataPanel, con);




		JPanel optionPanel = new JPanel(new BorderLayout());
		JPanel internalPanel = new JPanel();
		GroupLayout layout = new GroupLayout(internalPanel);
		JButton quit = new JButton("Save and Quit");
		quit.addActionListener(new QuitButtonListener());
		JButton reset = new JButton("Clear Filters");
		JButton clear = new JButton("Clear Data");
		clear.addActionListener(new ClearButtonListener());
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(quit).addComponent(reset).addComponent(clear));
		optionPanel.add(internalPanel, BorderLayout.SOUTH);
		optionPanel.add(new InputPanel(dataPanel, this), BorderLayout.NORTH);


		con.fill = GridBagConstraints.NONE;
		con.anchor = GridBagConstraints.SOUTHWEST;
		con.gridx = 0;
		con.gridy = 2;
		con.weightx = 1;
		con.weighty = 1;
		con.gridwidth = 2;
		con.gridheight = 1;
		con.ipadx = 0;
		con.ipady = 0;

		add(optionPanel, con);







		pack();
		setSize(1000, 750);
		setVisible(true);
	}

	public void setVarPaneFalse()
	{
		Component[] variablePaneComponents = variablePane.getComponents();
		for(int i = 0; i < variablePaneComponents.length; i++)
		{
			variablePaneComponents[i].setEnabled(false);
			variablePaneComponents[i].setForeground(Color.GRAY);
		}
	}

	public void setVarPaneTrue()
	{
		Component[] variablePaneComponents = variablePane.getComponents();
		for(int i = 0; i < variablePaneComponents.length; i++)
		{
			variablePaneComponents[i].setEnabled(true);
			variablePaneComponents[i].setForeground(Color.BLACK);
		}
	}

	private class TimeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new ConfirmationFrame(new TimePanel(), "Time");
		}
	}

	private class WeightButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new ConfirmationFrame(new WeightPanel(), "Weight");
		}
	}

	private class AirlineButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new ConfirmationFrame(new CompanyPanel(), "Airline");
		}
	}

	private class QuitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}

	private class ClearButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dataPanel.getPanelTextArea().setText("");
		}
	}

}
