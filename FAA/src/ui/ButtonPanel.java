package ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton save;
	private JButton open;
	private JButton filter;
	private JButton limit;


	public ButtonPanel(){
		setLayout(new GridLayout(3, 3));

		save = new JButton("Save");
		open = new JButton("Open");
		filter = new JButton("Filter");
		limit = new JButton("Choose Display Limit");

		add(save);
		add(open);
		add(filter);
		add(limit);
	}


	public JButton getSave(){
		return save;
	}
	

	public JButton getOpen(){
		return open;
	}
	
	public JButton getFilter(){
		return filter;
	}
	
	public JButton getLimit(){
		return limit;
	}
	
}
