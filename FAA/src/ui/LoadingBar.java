package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;

public class LoadingBar extends JPanel implements ActionListener, PropertyChangeListener 
{ 
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JProgressBar progressBar;
	private Task task;

	class Task extends SwingWorker<Void, Void> 
	{
		public Void doInBackground() 
		{
			Random random = new Random();
			int progress = 0;
			setProgress(0);
			while (progress < 100) 
			{
				try 
				{
					Thread.sleep(random.nextInt(50));
				}
				catch (InterruptedException ignore)
				{
				}

				progress += random.nextInt(3);
				setProgress(Math.min(progress, 100));
			}

			frame.dispose();
			return null;
		}

		public void done() 
		{
			setCursor(null);
		}
		
	}

	public LoadingBar() 
	{
		super(new BorderLayout());

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		JPanel panel = new JPanel();
		panel.add(progressBar);

		add(panel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 20));
		
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();
	}


	public void actionPerformed(ActionEvent evt) 
	{
	}


	public void propertyChange(PropertyChangeEvent e) 
	{
		if ("progress" == e.getPropertyName()) 
		{
			int progress = (Integer) e.getNewValue();
			progressBar.setValue(progress);
		} 
	}

	public void createAndShowGUI() 
	{
		frame = new JFrame("Loading");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new LoadingBar();
		newContentPane.setOpaque(true); 
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}
	
}
