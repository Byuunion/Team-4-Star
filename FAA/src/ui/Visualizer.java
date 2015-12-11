package ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame; 


public class Visualizer extends ApplicationFrame
{
	private static final long serialVersionUID = 1L;


	public Visualizer(String applicationTitle, String chartTitle, Map<String, Integer> plane)
	{
		super(applicationTitle);
		JFreeChart chart = ChartFactory.createPieChart("Plane Types", pieChart(plane), true, true, false);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public static DefaultPieDataset pieChart(Map<String, Integer> planes) {
		DefaultPieDataset data = new DefaultPieDataset();
		Iterator it = planes.entrySet().iterator();
		int count = 0;
	    
		while (it.hasNext() && count < 11) {
	        Map.Entry pair = (Map.Entry)it.next();
	        data.setValue((String)pair.getKey(), (Integer)pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	        count++;
	    }

		return data;
	}
}
