package yi_java4st_1team.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.color.CMMException;

import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.block.ColumnArrangement;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReportPanel extends JPanel implements ActionListener {
	private JPanel pReportSelect;
	private JLabel lblTitle;
	private JLabel lblReportSelectSub;
	private JPanel panel_1;
	private JPanel pMonth;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblPriceTotal1;
	private JLabel lblPriceTotal2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel pYear;
	private JLabel label;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel label_1;
	private JLabel lblXxxxx;
	private JComboBox cbMonth;
	private JLabel lblcbMonth;
	private JLabel lblcbYear;
	private JComboBox cbYear;
	private JLabel lblOrderTotal1;
	private JLabel lblOrderTotal2;
	private JLabel lblEventTotal1;
	private JLabel lblEventTotal2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;

	/**
	 * Create the panel.
	 */
	public ReportPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		pReportSelect = new JPanel();
		pReportSelect.setBounds(12, 10, 948, 165);
		add(pReportSelect);
		pReportSelect.setLayout(null);
		
		lblTitle = new JLabel("영업 현황 보고서");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(280, 10, 389, 40);
		pReportSelect.add(lblTitle);
		
		lblReportSelectSub = new JLabel("보고서 선택");
		lblReportSelectSub.setFont(new Font("굴림", Font.BOLD, 15));
		lblReportSelectSub.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportSelectSub.setBounds(12, 20, 154, 47);
		pReportSelect.add(lblReportSelectSub);
		
		cbMonth = new JComboBox();
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
		cbMonth.setBounds(339, 93, 97, 40);
		pReportSelect.add(cbMonth);
		
		lblcbMonth = new JLabel("월별");
		lblcbMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblcbMonth.setFont(new Font("굴림", Font.BOLD, 20));
		lblcbMonth.setBounds(230, 91, 97, 40);
		pReportSelect.add(lblcbMonth);
		
		lblcbYear = new JLabel("연도별");
		lblcbYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblcbYear.setFont(new Font("굴림", Font.BOLD, 20));
		lblcbYear.setBounds(12, 91, 97, 40);
		pReportSelect.add(lblcbYear);
		
		cbYear = new JComboBox();
		cbYear.addActionListener(this);
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"2020", "2019", "2018", "2017", "2016", "2015"}));
		cbYear.setBounds(121, 93, 97, 40);
		pReportSelect.add(cbYear);
		
		panel_1 = new JPanel();
		panel_1.setBounds(12, 185, 948, 439);
		add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		pMonth = new JPanel();
		pMonth.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.add(pMonth, "name_627944000059900");
		pMonth.setLayout(null);
		
		lblNewLabel_2 = new JLabel("월별 영업현황");
		lblNewLabel_2.setBounds(10, 10, 928, 35);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 30));
		pMonth.add(lblNewLabel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 928, 326);
		pMonth.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		for(Component p : table.getComponents()) {
			if(table.getColumnSelectionAllowed()) {
			
			}
		}
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"01", "2015-05-15", "고연정", "커트", "일반", "15,000"},
				{"02", "2015-05-16", "김연지", "커트", "일반", "15,000"},
				{"03", "2015-05-17", "이나라", "커트", "일반", "15,000"},
				{"04", "2015-05-17", "최순호", "커트", "일반", "15,000"},
				{"05", "2015-05-17", "김대훈", "커트", "일반", "15,000"},
				{"06", "2015-05-18", "이지수", "커트", "일반", "15,000"},
				{"07", "2015-05-18", "김혜진", "커트", "일반", "15,000"},
				{"08", "2015-05-19", "박현찬", "커트", "일반", "15,000"},
		
				
			},
			new String[] {
				"\uC601\uC5C5\uBC88\uD638", "\uC601\uC5C5\uC77C\uC790", "\uACE0\uAC1D\uBA85", "\uD5E4\uC5B4\uBA85", "\uC774\uBCA4\uD2B8\uBA85", "\uAE08\uC561"
			}
		));
		scrollPane.setColumnHeaderView(table);
		
		lblPriceTotal1 = new JLabel("금액 총계");
		lblPriceTotal1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriceTotal1.setFont(new Font("굴림", Font.BOLD, 20));
		lblPriceTotal1.setBounds(645, 380, 135, 48);
		pMonth.add(lblPriceTotal1);
		
		lblPriceTotal2 = new JLabel("XXXX건");
		lblPriceTotal2.setFont(new Font("굴림", Font.BOLD, 20));
		lblPriceTotal2.setBounds(792, 379, 146, 50);
		pMonth.add(lblPriceTotal2);
		
		lblOrderTotal1 = new JLabel("총 건수");
		lblOrderTotal1.setFont(new Font("굴림", Font.BOLD, 20));
		lblOrderTotal1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderTotal1.setBounds(337, 381, 135, 48);
		pMonth.add(lblOrderTotal1);
		
		lblOrderTotal2 = new JLabel("XXXX건");
		lblOrderTotal2.setFont(new Font("굴림", Font.BOLD, 20));
		lblOrderTotal2.setBounds(484, 381, 135, 48);
		pMonth.add(lblOrderTotal2);
		
		lblEventTotal1 = new JLabel("이벤트 총 건수");
		lblEventTotal1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEventTotal1.setFont(new Font("굴림", Font.BOLD, 20));
		lblEventTotal1.setBounds(36, 381, 159, 48);
		pMonth.add(lblEventTotal1);
		
		lblEventTotal2 = new JLabel("XX건");
		lblEventTotal2.setFont(new Font("굴림", Font.BOLD, 20));
		lblEventTotal2.setBounds(207, 381, 135, 48);
		pMonth.add(lblEventTotal2);
		
		pYear = new JPanel();
		pYear.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.add(pYear, "name_678998179137400");
		pYear.setLayout(null);
		
		label = new JLabel("연도별 영업현황");
		label.setBounds(10, 10, 928, 35);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 30));
		pYear.add(label);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 45, 928, 331);
		pYear.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"01", "2015-01-15", "고연정", "커트", "일반", "15,000"},
				{"02", "2015-02-16", "김연지", "커트", "일반", "15,000"},
				{"03", "2015-03-17", "이나라", "커트", "일반", "15,000"},
				{"04", "2015-04-17", "최순호", "커트", "일반", "15,000"},
				{"05", "2015-05-17", "김대훈", "커트", "일반", "15,000"},
				{"06", "2015-06-17", "정준하", "커트", "일반", "15,000"},
				{"07", "2015-07-17", "유재석", "커트", "일반", "15,000"},
				{"08", "2015-08-17", "노홍철", "커트", "일반", "15,000"},
				{"09", "2015-09-17", "이준", "커트", "일반", "15,000"},
			
			},
			new String[] {
				"영업번호","영업일자","고객명","헤어명","이벤트명","금액"
			}
		));
		table_1.setFont(new Font("휴먼매직체", Font.PLAIN, 12));
		scrollPane_1.setViewportView(table_1);
		
		label_1 = new JLabel("금액 총계");
		label_1.setFont(new Font("굴림", Font.BOLD, 20));
		label_1.setBounds(664, 386, 135, 48);
		pYear.add(label_1);
		
		lblXxxxx = new JLabel("XXXXX원");
		lblXxxxx.setFont(new Font("굴림", Font.BOLD, 15));
		lblXxxxx.setBounds(792, 386, 146, 50);
		pYear.add(lblXxxxx);
		
		label_4 = new JLabel("이벤트 총 건수");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("굴림", Font.BOLD, 20));
		label_4.setBounds(10, 381, 159, 48);
		pYear.add(label_4);
		
		label_5 = new JLabel("XX건");
		label_5.setFont(new Font("굴림", Font.BOLD, 20));
		label_5.setBounds(181, 381, 135, 48);
		pYear.add(label_5);
		
		label_6 = new JLabel("총 건수");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("굴림", Font.BOLD, 20));
		label_6.setBounds(302, 381, 135, 48);
		pYear.add(label_6);
		
		label_7 = new JLabel("XXXX건");
		label_7.setFont(new Font("굴림", Font.BOLD, 20));
		label_7.setBounds(449, 386, 135, 48);
		pYear.add(label_7);
	}
	private String[] colmnsName() {
		return new String[] {
			"영업번호", "영업일자", "고객명", "헤어명", "이벤트명", "금액"
		};
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cbYear) {
			actionPerformedCbYear(arg0);
		}
	}
	protected void actionPerformedCbYear(ActionEvent arg0) {
		if(cbMonth.getSelectedItem().toString()=="5월" && cbYear.getSelectedItem().toString()=="2015") {
			pYear.setVisible(false);
			pMonth.setVisible(true);
			System.out.println(cbMonth.getSelectedItem().toString()=="5월");
		}
		if(cbYear.getSelectedItem().toString()=="2016") {
			pYear.setVisible(true);
			pMonth.setVisible(false);
		}
		
		}
	}

