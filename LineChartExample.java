import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartExample extends JFrame {

  private static final long serialVersionUID = 1L;

  public LineChartExample(String title) {
    super(title);
    DefaultCategoryDataset dataset = createDataset();

    JFreeChart chart = ChartFactory.createLineChart(
        "CPU Utillization", 
        "Time", 
        "Percentage", 
        dataset
        );

    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private DefaultCategoryDataset createDataset() {

    String series1 = "Time";

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    dataset.addValue(0, series1, "0");
    dataset.addValue(100, series1, "1");
    dataset.addValue(0, series1, "2");
    dataset.addValue(100, series1, "3");
    dataset.addValue(0, series1, "4");
    dataset.addValue(100, series1, "5");
    dataset.addValue(0, series1, "6");
    return dataset;
  }
}

