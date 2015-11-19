package ui;

import java.awt.*;
import javax.swing.*;

public class WeightPanel extends JPanel
{
	private static final long serialVersionUID = 1L;


	public WeightPanel()
	{
		setLayout(new GridLayout(2, 1));
		
		JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 0, 500, 0);
		slider1.setFont(new Font("Tahoma", Font.BOLD, 12));
		slider1.setMajorTickSpacing(100);
		slider1.setMinorTickSpacing(25);
		slider1.setPaintLabels(true);
		slider1.setPaintTicks(true);
		slider1.setPaintTrack(true);
		slider1.setAutoscrolls(true);
		
		JPanel internalMax = new JPanel();
		internalMax.setBorder(BorderFactory.createTitledBorder("Max. Tonnage"));
		internalMax.add(slider1);
		
		
		
		JSlider slider2 = new JSlider(JSlider.HORIZONTAL,0, 500, 0);
		slider2.setFont(new Font("Tahoma", Font.BOLD, 12));
		slider2.setMajorTickSpacing(100);
		slider2.setMinorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.setPaintTicks(true);
		slider2.setPaintTrack(true);
		slider2.setAutoscrolls(true);
		
		JPanel internalMin = new JPanel();
		internalMin.setBorder(BorderFactory.createTitledBorder("Min. Tonnage"));
		internalMin.add(slider2);
		
		add(internalMax);
		add(internalMin);
		
		
	


		
		
		
		setBorder(BorderFactory.createTitledBorder("Flight Weights"));
	}
}
