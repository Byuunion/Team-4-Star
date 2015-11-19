package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DanInterface extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void createLayout() {
		JFrame frame = new JFrame("Dan Chart Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();

		JPanel top = new JPanel();
		JPanel center = new JPanel();
		JButton pieButton = new JButton("Pie Chart");
		JButton scatterButton = new JButton("Scatter Plot Chart");
		JButton histButton = new JButton("Histogram Chart");
		JButton spineButton = new JButton("XY Spine Chart");

		center.setPreferredSize(new Dimension(800, 600));

		pieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				center.removeAll();
				center.add(pieChart());
				frame.validate();
			}
		});

		scatterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				center.removeAll();
				center.add(scatterChart());
				frame.validate();
			}
		});

		histButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				center.removeAll();
				center.add(histoChart());
				frame.validate();
			}
		});

		spineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				center.removeAll();
				center.add(xyChart());
				frame.validate();
			}
		});

		top.add(pieButton);
		top.add(scatterButton);
		top.add(histButton);
		top.add(spineButton);
		pane.add(top, BorderLayout.PAGE_START);
		pane.add(center, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		createLayout();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static ChartPanel pieChart() {
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Category 1", 45.2);
		data.setValue("Category 2", 27.9);
		data.setValue("Category 3", 14.5);
		// create a chart...
		JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", data, true, // legend?
				true, // tooltips?
				false // URLs?
		);

		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}

	public static ChartPanel scatterChart() {
		JFreeChart scatt = createChart(createDataset());
		ChartPanel panel = new ChartPanel(scatt);
		return panel;
	}

	public static ChartPanel histoChart() {
		HistogramDataset dataset = new HistogramDataset();
		dataset.setType(HistogramType.RELATIVE_FREQUENCY);
		String plotTitle = "ChartUtils: Histogram";
		String xaxis = "bin #";
		String yaxis = "val";
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		boolean showLegend = false;
		boolean toolTips = true;
		boolean urls = false;
		JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis, yaxis, (IntervalXYDataset) createDataset(),
				orientation, showLegend, toolTips, urls);
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}

	public static ChartPanel xyChart() {
		NumberAxis xax = new NumberAxis("x");
		NumberAxis yax = new NumberAxis("y");
		XYSplineRenderer a = new XYSplineRenderer();
		a.setPrecision(10);
		XYPlot xyplot = new XYPlot(createDataset(), xax, yax, a);

		JFreeChart chart = new JFreeChart(xyplot);
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}

	private static JFreeChart createChart(XYDataset dataset) {
		JFreeChart chart = ChartFactory.createScatterPlot("Scatter Plot Demo 1", "X", "Y", dataset,
				PlotOrientation.VERTICAL, true, false, false);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setNoDataMessage("NO DATA");
		plot.setDomainZeroBaselineVisible(true);
		plot.setRangeZeroBaselineVisible(true);

		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		renderer.setSeriesOutlinePaint(0, Color.black);
		renderer.setUseOutlinePaint(true);
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		domainAxis.setAutoRangeIncludesZero(false);
		domainAxis.setTickMarkInsideLength(2.0f);
		domainAxis.setTickMarkOutsideLength(0.0f);

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setTickMarkInsideLength(2.0f);
		rangeAxis.setTickMarkOutsideLength(0.0f);

		return chart;
	}

	private static XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Object 1");
		XYSeries series2 = new XYSeries("Object 2");
		XYSeries series3 = new XYSeries("Object 3");

		series1.add(1.0, 2.0);
		series1.add(2.0, 3.0);
		series1.add(3.0, 2.5);
		series1.add(3.5, 2.8);
		series1.add(4.2, 6.0);

		series2.add(2.0, 1.0);
		series2.add(2.5, 2.4);
		series2.add(3.2, 1.2);
		series2.add(3.9, 2.8);
		series2.add(4.6, 3.0);

		series3.add(1.2, 4.0);
		series3.add(2.5, 4.4);
		series3.add(3.8, 4.2);
		series3.add(4.3, 3.8);
		series3.add(4.5, 4.0);

		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		return dataset;
	}
}
