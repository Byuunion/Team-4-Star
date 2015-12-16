package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Model;
import ui.UIScreen;
import ui.Visualizer;


public class Controller
{
	public static void main(String[] args) 
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Controller();
	}

	// Start Class

	private static UIScreen ui;
	private static Model model;
	private Integer limit;


	public Controller() 
	{
		ui = new UIScreen();
		model = new Model();
		generateListeners();
	}


	public void generateListeners() 
	{
		ActionListener saveAction = new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				JFileChooser saveFile = new JFileChooser();

				if(saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						model.writeData(saveFile.getSelectedFile());
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		ui.getButtonPanel().getSave().addActionListener(saveAction);


		ActionListener openAction = new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				JFileChooser openFile = new JFileChooser("C:");

				if(openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					model.setFile(openFile.getSelectedFile());
					ui.getInfoPanel().setPanelTextArea(model.generateUniverseString());
					ui.getFilterPanel().enableButtons();
					ui.getButtonPanel().enableButtons();
				}

			}
		};
		ui.getButtonPanel().getOpen().addActionListener(openAction);


		ActionListener limitSelectionAction = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int messageType = JOptionPane.INFORMATION_MESSAGE;

				String value = JOptionPane.showInputDialog(null,
						"Enter A Value for The Number of Records to Be Displayed", 
						"Input Dialog Box", messageType);

				if(value != null)
				{
					setLimit(Integer.parseInt(value));
					updateDisplay();
				}
			}
		};
		ui.getButtonPanel().getLimit().addActionListener(limitSelectionAction);


		ActionListener visualizeAction = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Visualizer("Plane Types", model.GetPlanes(), 
						model.GetDestinations(), model.GetFlights(), 
						model.GetOrigins(), model.GetStarts());
			}
		};
		ui.getButtonPanel().getVisualize().addActionListener(visualizeAction);


		ActionListener filterAction = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ui.getFilterPanel().setFilters();
				model.filterGalaxy(
						ui.getFilterPanel().getFilters()[0], 
						ui.getFilterPanel().getFilters()[1], 
						ui.getFilterPanel().getFilters()[2], 
						ui.getFilterPanel().getFilters()[3], 
						ui.getFilterPanel().getFilters()[4], 
						ui.getFilterPanel().getFilters()[5], 
						ui.getFilterPanel().getFilters()[6], 
						ui.getFilterPanel().getFilters()[7]
						);
				
				updateDisplay();
			}
		};
		ui.getFilterPanel().getApplyButton().addActionListener(filterAction);
		
		
		ActionListener resetAction = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				model.generateGalaxy();
				updateDisplay();
			}
		};
		ui.getButtonPanel().getReset().addActionListener(resetAction);
		
	}


	public static UIScreen getUI() 
	{
		return ui;
	}


	public static void setUI(UIScreen screen) 
	{
		ui = screen;
	}


	public Integer getLimit() 
	{
		return limit;
	}


	public void setLimit(int val) 
	{
		limit = val;
	}


	public void updateDisplay(int limit) 
	{
		ui.getInfoPanel().setPanelTextArea(model.generateGalaxyString(limit));
	}
	
	
	public void updateDisplay() 
	{
		ui.getInfoPanel().setPanelTextArea(model.generateGalaxyString(model.getGalaxy().size() - 1));
	}

}
