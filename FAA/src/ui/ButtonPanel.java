package ui;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class ButtonPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton save;
	private JButton open;
	private JButton limit;
	private JButton visualize;
	private JButton reset;

	public ButtonPanel()
	{
		setLayout(new GridLayout(2, 3));

		save = new JButton("Save");
		open = new JButton("Open");
		limit = new JButton("Choose Display Limit");
		visualize = new JButton("Visualize");
		reset = new JButton("Reset Filters");
		
		save.setEnabled(false);
		limit.setEnabled(false);
		visualize.setEnabled(false);
		reset.setEnabled(false);
		
		
		add(save);
		add(open);
		add(limit);
		add(visualize);
		add(reset);
		
		
		TitledBorder border = BorderFactory.createTitledBorder("Options");
		border.setTitleJustification(TitledBorder.CENTER);
		setBorder(border);
	}
	
	
	public void enableButtons()
	{
		save.setEnabled(true);
		limit.setEnabled(true);
		visualize.setEnabled(true);
		reset.setEnabled(true);
	}


	public JButton getSave()
	{
		return save;
	}
	

	public JButton getOpen()
	{
		return open;
	}
	

	public JButton getLimit()
	{
		return limit;
	}

	
	public JButton getReset()
	{
		return reset;
	}
	

	public JButton getVisualize() 
	{
		return visualize;
	}
	
}
