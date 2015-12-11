package ui;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities; 


public class Visualizer extends ApplicationFrame{
	private static final long serialVersionUID = 1L;


	public Visualizer(String applicationTitle, Map<String, Integer> plane,
					  Map<String, Integer> dest, Map<String, Integer> flig,
					  Map<String, Integer> orig, Map<String, Integer> star){
		super(applicationTitle);
		JFrame chartFrame = new JFrame();
		JTabbedPane tabsPane = new JTabbedPane();
		
		JFreeChart planeChart = ChartFactory.createPieChart("Plane Types", pieChartData(plane), true, true, false);
		JFreeChart destChart = ChartFactory.createPieChart("Destinations", pieChartData(dest), true, true, false);
		JFreeChart fligChart = ChartFactory.createPieChart("Flight Types", pieChartData(flig), true, true, false);
		JFreeChart origChart = ChartFactory.createPieChart("Origin Fixes", pieChartData(orig), true, true, false);
		JFreeChart starChart = ChartFactory.createPieChart("Start Center", pieChartData(star), true, true, false);

		ChartPanel planeChartPanel = new ChartPanel(planeChart);
		ChartPanel destChartPanel = new ChartPanel(destChart);
		ChartPanel fligChartPanel = new ChartPanel(fligChart);
		ChartPanel origChartPanel = new ChartPanel(origChart);
		ChartPanel starChartPanel = new ChartPanel(starChart);
		
		JComponent planePanel = makeChartPanel(planeChartPanel); 
		JComponent destPanel = makeChartPanel(destChartPanel); 
		JComponent fligPanel = makeChartPanel(fligChartPanel);
		JComponent origPanel = makeChartPanel(origChartPanel);
		JComponent starPanel = makeChartPanel(starChartPanel);
		
		tabsPane.addTab("Planes Pie Graph", null, planePanel, "Plane Pie Graph");
		tabsPane.addTab("Destinations Pie Graph", null, destPanel, "Destinations Pie Graph");
		tabsPane.addTab("Flight Type Pie Graph", null, fligPanel, "Flight Type Pie Graph");
		tabsPane.addTab("Origin Fix Pie Graph", null, origPanel, "Origin Fix Pie Graph");
		tabsPane.addTab("Start Center Pie Graph", null, starPanel, "Start Center Pie Graph");
		tabsPane.setPreferredSize(new java.awt.Dimension(800, 600));
		
		chartFrame.add(tabsPane);
		
		chartFrame.pack();
		RefineryUtilities.centerFrameOnScreen(chartFrame);
		chartFrame.setVisible(true);
		
		
		//setContentPane(chartPanel);
	}
	
	public static DefaultPieDataset pieChartData(Map<String, Integer> dataMap) {
		DefaultPieDataset data = new DefaultPieDataset();
		Iterator it = dataMap.entrySet().iterator();
		int count = 0;
	    
		while (it.hasNext() && count < 11) {
	        Map.Entry pair = (Map.Entry)it.next();
	        data.setValue((String)pair.getKey(), (Integer)pair.getValue());
	        it.remove(); 
	        count++;
	    }

		return data;
	}
	
	protected JComponent makeChartPanel(ChartPanel chart) {
        JPanel panel = new JPanel(false);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(chart);
        return panel;
    }
}
