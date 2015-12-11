package ui;

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
		JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", pieChart(plane), true, true, false);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(chartPanel);
	}
	
	public static DefaultPieDataset pieChart(Map<String, Integer> planes) {
		DefaultPieDataset data = new DefaultPieDataset();
		
		for (Map.Entry entry : planes.entrySet()) {
		    data.setValue((String) entry.getKey(),(int)entry.getValue());
		}

		return data;
	}
}
