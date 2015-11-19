package Mark1;

import java.awt.*;
import javax.swing.*;

public class TimePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private JCheckBox twelveAM;
	private JCheckBox oneAM;
	private JCheckBox twoAM;
	private JCheckBox threeAM;
	private JCheckBox fourAM;
	private JCheckBox fiveAM;
	private JCheckBox sixAM;
	private JCheckBox sevenAM;
	private JCheckBox eightAM;
	private JCheckBox nineAM;
	private JCheckBox tenAM;
	private JCheckBox elevenAM;
	private JCheckBox twelvePM;	
	private JCheckBox onePM;
	private JCheckBox twoPM;
	private JCheckBox threePM;
	private JCheckBox fourPM;
	private JCheckBox fivePM;
	private JCheckBox sixPM;
	private JCheckBox sevenPM;
	private JCheckBox eightPM;
	private JCheckBox ninePM;
	private JCheckBox tenPM;
	private JCheckBox elevenPM;

	public TimePanel()
	{
		setLayout(new GridLayout(4, 6));
	
		twelveAM = new JCheckBox("12:00 AM");
		oneAM = new JCheckBox("1:00 AM");
		twoAM = new JCheckBox("2:00 AM");
		threeAM = new JCheckBox("3:00 AM");
		fourAM = new JCheckBox("4:00 AM");
		fiveAM = new JCheckBox("5:00 AM");
		sixAM = new JCheckBox("6:00 AM");
		sevenAM = new JCheckBox("7:00 AM");
		eightAM = new JCheckBox("8:00 AM");
		nineAM = new JCheckBox("9:00 AM");
		tenAM = new JCheckBox("10:00 AM");
		elevenAM = new JCheckBox("11:00 AM");
		twelvePM = new JCheckBox("12:00 PM");
		onePM = new JCheckBox("1:00 PM");
		twoPM = new JCheckBox("2:00 PM");
		threePM = new JCheckBox("3:00 PM");
		fourPM = new JCheckBox("4:00 PM");
		fivePM = new JCheckBox("5:00 PM");
		sixPM = new JCheckBox("6:00 PM");
		sevenPM = new JCheckBox("7:00 PM");
		eightPM = new JCheckBox("8:00 PM");
		ninePM = new JCheckBox("9:00 PM");
		tenPM = new JCheckBox("10:00 PM");
		elevenPM = new JCheckBox("11:00 PM");
		
		add(twelveAM);
		add(oneAM);
		add(twoAM);
		add(threeAM);
		add(fourAM);
		add(fiveAM);
		add(sixAM);
		add(sevenAM);
		add(eightAM);
		add(nineAM);
		add(tenAM);
		add(elevenAM);
		add(twelvePM);
		add(onePM);
		add(twoPM);
		add(threePM);
		add(fourPM);
		add(fivePM);
		add(sixPM);
		add(sevenPM);
		add(eightPM);
		add(ninePM);
		add(tenPM);
		add(elevenPM);
		
		setBorder(BorderFactory.createTitledBorder("Take-off Flight Times"));
	}
}
