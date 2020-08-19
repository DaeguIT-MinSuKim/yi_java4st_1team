package hairrang.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import hairrang.dto.Sales;

public class hairOrderSearch extends JPanel {
	private JPanel panel;
	private JButton btnSreach;
	private JButton btnCancel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private hairOrder table;
	private JDateChooser beforeDate;
	private JDateChooser afterDate;
	private JLabel lblTotal;
	private JLabel lblTotal2;
	private ArrayList<Sales> slist = new ArrayList<Sales>();
	private Date date = new Date();

	/**
	 * Create the panel.
	 */
	public hairOrderSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel);
		panel.setBounds(0, 0, 460, 690);
		panel.setLayout(null);
		panel.setLayout(null);

		JLabel lblDay = new JLabel("날짜");
		lblDay.setBounds(94, 27, 40, 24);
		panel.add(lblDay);
		lblDay.setFont(new Font("굴림", Font.PLAIN, 20));
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblDay2 = new JLabel("~");
		lblDay2.setBounds(247, 28, 15, 23);
		panel.add(lblDay2);
		lblDay2.setFont(new Font("굴림", Font.BOLD, 19));
		lblDay2.setHorizontalAlignment(SwingConstants.CENTER);

		JRadioButton rdbtnday = new JRadioButton("day");
		rdbtnday.addActionListener(Sreachaction);
		rdbtnday.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnday.setBounds(156, 57, 47, 23);
		panel.add(rdbtnday);
		buttonGroup.add(rdbtnday);

		JRadioButton rdbtntwoWeek = new JRadioButton("twoweek");
		rdbtntwoWeek.addActionListener(Sreachaction);
		rdbtntwoWeek.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtntwoWeek.setBounds(207, 57, 73, 23);
		panel.add(rdbtntwoWeek);
		buttonGroup.add(rdbtntwoWeek);

		JRadioButton rdbtnMonth = new JRadioButton("month");
		rdbtnMonth.addActionListener(Sreachaction);
		rdbtnMonth.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonth.setBounds(284, 57, 61, 23);
		panel.add(rdbtnMonth);
		buttonGroup.add(rdbtnMonth);

		beforeDate = new JDateChooser();
		beforeDate.getDateEditor().addPropertyChangeListener(DateLisner);
		beforeDate.setDate(date);
		beforeDate.setBounds(146, 30, 89, 21);
		panel.add(beforeDate);

		afterDate = new JDateChooser();
		afterDate.setDate(date);
		afterDate.setBounds(274, 30, 89, 21);
		panel.add(afterDate);

		btnSreach = new JButton("검색");
		btnSreach.addActionListener(Sreachaction);
		btnSreach.setBounds(184, 113, 70, 23);
		panel.add(btnSreach);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(Sreachaction);
		btnCancel.setBounds(266, 113, 70, 23);
		panel.add(btnCancel);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 146, 460, 459);
		panel.add(tablePanel);
		tablePanel.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);

		table = new hairOrder();
		scrollPane.setViewportView(table);
		table.setItems(slist);

		lblTotal = new JLabel("총 금액");
		lblTotal.setForeground(Color.RED);
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(387, 615, 102, 35);
		panel.add(lblTotal);

		lblTotal2 = new JLabel("총 금액");
		lblTotal2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal2.setBounds(273, 615, 102, 35);
		panel.add(lblTotal2);
	}

	public void orderSreachset(Sales s) {
		slist.add(s);
		table.addRow(s);
		
	}

	ActionListener Sreachaction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JRadioButton) {
				if (e.getActionCommand().equals("day")) {
					System.out.println("day");
					beforeOneDate();
				}
				if (e.getActionCommand().equals("twoweek")) {
					System.out.println("twoweek");
					beforeTwoWeekDate();
				}
				if (e.getActionCommand().equals("month")) {
					System.out.println("month");
					beforeMonthDate();

				}
			}
			if (e.getSource() == btnSreach) {
				ChangeDateSreach();

			}
			if (e.getSource() == btnCancel) {
				System.out.println("can");
				beforeDate.setDate(date);
				afterDate.setDate(date);
			}
			if(e.getSource() == beforeDate) {
				System.out.println(e.getActionCommand());
			}
		}

		@SuppressWarnings("deprecation")
		private void ChangeDateSreach() {
			Date beforetest = beforeDate.getDate();
			Date aftertest = afterDate.getDate();
			
			
			for(int i = slist.size() - 1; i >= 0; i--) {
				String result = slist.get(i).getSalesDay();
				String[] result1 = result.split("-");
				Calendar caltest = Calendar.getInstance();
				int testy = Integer.parseInt(result1[0].trim());
				int testm = Integer.parseInt(result1[1].trim());
				int testd = Integer.parseInt(result1[2].trim());
				caltest.set(testy, testm, testd);
				Date testdate = new Date(caltest.getTimeInMillis());
				
				if(beforetest.compareTo(testdate)>0) {
					table.reset(i);
					System.out.println("과거");
					table.addRow(slist.get(i));
				}
				if(aftertest.compareTo(testdate)<0) {
					table.reset(i);
					System.out.println("미래");
					table.addRow(slist.get(i));
					
				}
				
			}
			
		}

		private void beforeMonthDate() {
			int monthday = date.getMonth() - 1;
			date.setMonth(monthday);
			beforeDate.setDate(date);
			;
			date = new Date();

		}

		private void beforeTwoWeekDate() {
			int twoweek = date.getDate() - 14;
			date.setDate(twoweek);
			beforeDate.setDate(date);
			;
			date = new Date();

		}

		private void beforeOneDate() {
			int oneday = date.getDate() - 1;
			date.setDate(oneday);
			beforeDate.setDate(date);
			;
			date = new Date();
		}
	};
	
	PropertyChangeListener DateLisner = new PropertyChangeListener() {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			System.out.println("작동되나");
			System.out.println("evt"+evt);
			System.out.println("evt.getNewValue()"+evt.getNewValue());
			System.out.println("evt.getOldValue()"+evt.getOldValue());
			System.out.println("evt.getSource()"+evt.getSource());
		}
		
	};
		
	
	
	
}
