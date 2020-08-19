package yi_java4st_1team.component;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

@SuppressWarnings("serial")
public class chartPanel extends JPanel implements ActionListener {
	private JPanel panel;
	private JRadioButton OrderRadioButton01;
	private JPanel panel_report;
	private JLabel lblHairMain;
	private JLabel lblTotalCustom;
	private JLabel lblTotalBusinessDay;
	private JLabel lblTotalPrice;
	private JTextField tfTotalCustom;
	private JTextField tfTotalBusinessDay;
	private JTextField tfTotalPrice;
	private JRadioButton OrderRadioButton02;
	private JPanel panel_report2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_report1;
	private JRadioButton OrderRadioButton03;
	private JPanel panel_report3;

	/**
	 * Create the panel.
	 */
	public chartPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Report", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 10, 873, 598);
		add(panel);
		panel.setLayout(null);
		
		OrderRadioButton01 = new JRadioButton("주문현황1");
		buttonGroup.add(OrderRadioButton01);
		OrderRadioButton01.setFont(new Font("굴림", Font.BOLD, 15));
		OrderRadioButton01.setBounds(12, 528, 164, 41);
		panel.add(OrderRadioButton01);
		
		panel_report = new JPanel();
		panel_report.setBounds(12, 124, 841, 402);
		panel.add(panel_report);
		panel_report.setLayout(new CardLayout(0, 0));
		
		panel_report2 = new JPanel();
		panel_report.add(panel_report2, "name_628598352856800");
		panel_report2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_report1 = new JPanel();
		panel_report.add(panel_report1, "name_671370963706400");
		
		panel_report3 = new JPanel();
		panel_report.add(panel_report3, "name_773304070598600");
		panel_report3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblHairMain = new JLabel("헤어 현황");
		lblHairMain.setBounds(54, 24, 57, 15);
		panel.add(lblHairMain);
		
		lblTotalCustom = new JLabel("총고객수");
		lblTotalCustom.setBounds(12, 49, 57, 15);
		panel.add(lblTotalCustom);
		
		lblTotalBusinessDay = new JLabel("총영업수");
		lblTotalBusinessDay.setBounds(12, 74, 57, 15);
		panel.add(lblTotalBusinessDay);
		
		lblTotalPrice = new JLabel("총 금 액");
		lblTotalPrice.setBounds(12, 99, 57, 15);
		panel.add(lblTotalPrice);
		
		tfTotalCustom = new JTextField();
		tfTotalCustom.setBounds(81, 49, 116, 21);
		panel.add(tfTotalCustom);
		tfTotalCustom.setColumns(10);
		
		tfTotalBusinessDay = new JTextField();
		tfTotalBusinessDay.setBounds(81, 71, 116, 21);
		panel.add(tfTotalBusinessDay);
		tfTotalBusinessDay.setColumns(10);
		
		tfTotalPrice = new JTextField();
		tfTotalPrice.setBounds(81, 96, 116, 21);
		panel.add(tfTotalPrice);
		tfTotalPrice.setColumns(10);
		
		OrderRadioButton02 = new JRadioButton("주문현황2");
		buttonGroup.add(OrderRadioButton02);
		OrderRadioButton02.setFont(new Font("굴림", Font.BOLD, 15));
		OrderRadioButton02.addActionListener(this);
		OrderRadioButton02.setBounds(193, 537, 121, 23);
		panel.add(OrderRadioButton02);
		
		OrderRadioButton03 = new JRadioButton("PIECHART");
		OrderRadioButton03.addActionListener(this);
		OrderRadioButton03.setBounds(341, 537, 121, 23);
		panel.add(OrderRadioButton03);
		OrderRadioButton01.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == OrderRadioButton03) {
			actionPerformedOrderRadioButton03(e);
		}
		if (e.getSource() == OrderRadioButton02) {
			actionPerformedRdbtnNewRadioButton01(e);
		}
		
		if (e.getSource() == OrderRadioButton01) {
			actionPerformedRdbtnNewRadioButton(e);
		}
	
	}

	public void actionPerformedRdbtnNewRadioButton(ActionEvent e) {
	
		DefaultCategoryDataset dod = new DefaultCategoryDataset();
		dod.setValue(130.90, "CUT","CUT");
		dod.setValue(68.20, "DRY","DRY");
		dod.setValue(88.30, "SHAMPU","SHAMPU");
		dod.setValue(98.80, "FORM","FORM");
		dod.setValue(58.80, "MAGIC","MAGIC");
		dod.setValue(58.80, "TRITMENT","TRITMENT");
		dod.setValue(58.80, "AMPLE","AMPLE");
		dod.setValue(58.80, "ETC","ETC");
		
		JFreeChart jchart = ChartFactory.createBarChart3D("Hairrang Chart", "Hairrang Result", "Hairrnag Order", dod, PlotOrientation.VERTICAL, true, true, false);
		
		CategoryPlot plot = jchart.getCategoryPlot();
		plot.setRangeGridlinePaint(Color.black);
		
		
		ChartPanel chartpanel = new ChartPanel(jchart);

		panel_report1.removeAll();
		panel_report1.add(chartpanel);
		panel_report1.updateUI();
		
		panel_report1.setVisible(true);
		panel_report2.setVisible(false);
		panel_report3.setVisible(false);
	}
	

		public void actionPerformedRdbtnNewRadioButton01(ActionEvent e) {
			
			
			
			DefaultCategoryDataset dod2 = new DefaultCategoryDataset();
			dod2.setValue(151.90, "CUT","CUT");
			dod2.setValue(168.20, "DRY","DRY");
			dod2.setValue(188.30, "SHAMPU","SHAMPU");
			dod2.setValue(150.80, "FORM","FORM");
			dod2.setValue(230.80, "MAGIC","MAGIC");
			dod2.setValue(520.80, "TRITMENT","TRITMENT");
			dod2.setValue(350.80, "AMPLE","AMPLE");
			dod2.setValue(80.80, "ETC","ETC");
			
			JFreeChart jchart = ChartFactory.createBarChart3D("Hairrang Chart", "Hairrang Result", "Hairrnag Order", dod2, PlotOrientation.VERTICAL, true, true, false);
			
			CategoryPlot plot = jchart.getCategoryPlot();
			plot.setRangeGridlinePaint(Color.black);
			
			
			ChartPanel chartpanel = new ChartPanel(jchart);

			panel_report2.removeAll();
			panel_report2.add(chartpanel);	
			panel_report2.updateUI();
			
	
			panel_report2.setVisible(true);
			panel_report1.setVisible(false);
			panel_report3.setVisible(false);
			
			
			
			
		}
	protected void actionPerformedOrderRadioButton03(ActionEvent e) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("CUT", new Integer(10));
		pieDataset.setValue("DRY", new Integer(20));
		pieDataset.setValue("SHAMPU", new Integer(30));
		pieDataset.setValue("FORM", new Integer(40));
		JFreeChart Piechart = ChartFactory.createPieChart3D("Pie Chart", pieDataset, true, true,true);
	
	PiePlot3D p=(PiePlot3D)Piechart.getPlot();
	// p.setForegrou ndAlpha(TOP_ALIGNMENT);
	ChartFrame frame = new ChartFrame("Pie Chart",Piechart);
	
	ChartPanel chartpanel = new ChartPanel(Piechart);
	
	panel_report3.removeAll();
	panel_report3.add(chartpanel);	
	panel_report3.updateUI();
	
	panel_report3.setVisible(true);
	panel_report2.setVisible(false);
	panel_report1.setVisible(false);
	}
	}


