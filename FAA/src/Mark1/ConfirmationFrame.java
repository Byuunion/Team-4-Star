package Mark1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ConfirmationFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public ConfirmationFrame(JPanel panel, String title)
	{	
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		JButton ok = new JButton("Confirm");
		buttonPanel.add(ok);
		JButton cancel = new JButton("Cancel");
		buttonPanel.add(cancel);
		add(buttonPanel, BorderLayout.SOUTH);
		ok.addActionListener(new CloseButtonListener());
		cancel.addActionListener(new CloseButtonListener());
		setTitle(title);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
	}

	private class CloseButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}
}
