package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class InformationPanel extends JPanel
{
	private static final long serialVersionUID = 7290866987404009331L;
	private JTextArea textArea; 


	public InformationPanel()	
	{
		TitledBorder centerBorder = BorderFactory.createTitledBorder("Flight Data");
		centerBorder.setTitleJustification(TitledBorder.CENTER);
		setBorder(centerBorder);

		setLayout(new BorderLayout());

		textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createEtchedBorder());
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Serif", Font.PLAIN, 12));
		textArea.setLineWrap(false);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setVisible(true);

		JScrollPane pane = new JScrollPane(textArea, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.setPreferredSize(getMinimumSize());
		pane.setVisible(true);		
		add(pane, BorderLayout.CENTER);
		setVisible(true);
	}


	public JTextArea getPanelTextArea()
	{
		return textArea;
	}


	public void setPanelTextArea(String string)
	{
		textArea.setText(string);
	}

}
