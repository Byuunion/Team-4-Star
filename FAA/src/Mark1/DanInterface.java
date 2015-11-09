package Mark1;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class DanInterface extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -6717869781189553901L;
	private Label lblCount;    // Declare component Label
	private TextField tfCount; // Declare component TextField
	private Button btnCount;   // Declare component Button
	private int count = 0;
	   
	public DanInterface() 
	{
		super("Flight Pattern Analyzer Ver_0.2.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
