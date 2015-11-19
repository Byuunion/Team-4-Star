package Mark1;

import java.awt.*;
import javax.swing.*;

public class CompanyPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private JCheckBox American_Airlines;
	private JCheckBox Delta_Airlines;
	private JCheckBox JetBlue_Airlines;
	private JCheckBox Southwest_Airlines;
	private JCheckBox Spirit_Airlines;
	private JCheckBox United_Airlines;
	private JCheckBox Frontier_Airlines;


	public CompanyPanel()
	{
		setLayout(new GridLayout(4, 2));
	
		American_Airlines = new JCheckBox("American Airlines");
		Delta_Airlines = new JCheckBox("Delta Airlines");
		JetBlue_Airlines = new JCheckBox("JetBlue Airlines");
		Southwest_Airlines = new JCheckBox("Southwest Airlines");
		Spirit_Airlines = new JCheckBox("Spirit Airlines");
		United_Airlines = new JCheckBox("United Airlines");
		Frontier_Airlines = new JCheckBox("Frontier Airlines");
		
		add(American_Airlines);
		add(Delta_Airlines);
		add(JetBlue_Airlines);
		add(Southwest_Airlines);
		add(Spirit_Airlines);
		add(United_Airlines);
		add(Frontier_Airlines);

		
		setBorder(BorderFactory.createTitledBorder("Airline Company Selection"));
	}
}
