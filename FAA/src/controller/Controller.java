package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.ui.RefineryUtilities;

import model.Model;
import ui.FilterBox;
import ui.UIScreen;
import ui.Visualizer;

public class Controller {
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Controller();
	}

	///////

	private static UIScreen ui;
	private static Model model;
	private Integer limit;

	public Controller() {
		ui = new UIScreen();
		model = new Model();
		generateListeners();
	}

	public void generateListeners() {
		ActionListener saveAction = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser saveFile = new JFileChooser();
				if (saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						model.writeData(saveFile.getSelectedFile());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		ui.getButtonPanel().getSave().addActionListener(saveAction);

		ActionListener openAction = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser openFile = new JFileChooser("C:");

				if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					model.setFile(openFile.getSelectedFile());

					try {
						model.generateUniverse();
					} catch (IOException e) {
						e.printStackTrace();
					}

					ui.getInfoPanel().setPanelTextArea(model.generateUniverseString());
				}

			}
		};
		ui.getButtonPanel().getOpen().addActionListener(openAction);

		ActionListener filterAction = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				FilterBox box = new FilterBox();
				model.generateGalaxy();
				ui.getInfoPanel().setPanelTextArea(model.generateGalaxyString(limit));
			}
		};
		ui.getButtonPanel().getFilter().addActionListener(filterAction);

		ActionListener limitSelectionAction = new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int messageType = JOptionPane.INFORMATION_MESSAGE;
			     Integer answer = Integer.valueOf(JOptionPane.showInputDialog(ui, "Enter A Value for The Number of Recordes to Be Displayed", "Input Dialog Box", messageType));
			     setLimit(answer);
			     updateDisplay();
			}
		};
		ui.getButtonPanel().getLimit().addActionListener(limitSelectionAction);

		ActionListener visualizeAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visualizer chart = new Visualizer("Plane Types","Different Types of Planes",model.GetPlanes());
				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
			}
		};
		ui.getVisualizer().addActionListener(visualizeAction);

	}

	public static UIScreen getUI() {
		return ui;
	}

	public static void setUI(UIScreen screen) {
		ui = screen;
	}
	
	public Integer getLimit() {
		return limit;
	}
	
	public void setLimit(int val) {
		limit = val;
	}
	
	public void updateDisplay() {
		ui.getInfoPanel().setPanelTextArea(model.generateGalaxyString(limit));
	}

}
