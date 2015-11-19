package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class InputPanel extends JPanel
{
	private static final long serialVersionUID = 7290866987404009331L;
	private JTextArea textArea;
	private InformationPanel panel;
	private UI_Screen screen;

	public InputPanel(InformationPanel panel, UI_Screen screen)	
	{
		this.panel = panel;
		this.screen = screen;
		TitledBorder centerBorder = BorderFactory.createTitledBorder("Data Input");
		centerBorder.setTitleJustification(TitledBorder.CENTER);
		setBorder(centerBorder);
		setLayout(new BorderLayout());


		textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createEtchedBorder());
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Serif", Font.BOLD, 14));
		textArea.setLineWrap(true);
		textArea.setRows(1);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(true);
		textArea.setPreferredSize(new Dimension(500, 20));
		textArea.setVisible(true);
		textArea.addKeyListener(new SubmitButtonListener());




		add(textArea, BorderLayout.NORTH);
		setVisible(true);
	}

	private class SubmitButtonListener implements KeyListener
	{
		public void keyPressed(KeyEvent e) 
		{
		}

		public void keyReleased(KeyEvent e) 
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				textArea.setText("");
				
				LoadingBar loading = new LoadingBar();
				loading.createAndShowGUI();
				
				for(int i = 0; i < 100; i++)
				{
					panel.getPanelTextArea().append("FLIGHT DATA FLIGHT DATA FLIGHT DATA \n");
					screen.setVarPaneTrue();
				}
			}
		}

		public void keyTyped(KeyEvent e) 
		{
		}
	}

}
