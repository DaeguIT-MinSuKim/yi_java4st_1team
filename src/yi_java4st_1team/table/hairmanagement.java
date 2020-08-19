package yi_java4st_1team.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import yi_java4st_1team.dto.Event;
import yi_java4st_1team.dto.Guest;
import yi_java4st_1team.dto.Hairgoods;
import yi_java4st_1team.dto.Sales;

import java.awt.GridLayout;

public class hairmanagement extends JPanel {

	private JComboBox comboHair;
	private JComboBox comboEvent;
	private JLabel lblSalesCode2;
	private JLabel lblSalesDay2;
	private JLabel lblPrice2;
	private JLabel lblSale2;
	private JLabel lblEventCode2;
	private JLabel lblGuestCode2;
	private JLabel lblHairCode2;
	private JLabel lblVisitTime2;
	private JLabel lblGuestName2;
	private JLabel lblHairPrice2;
	private ArrayList<Hairgoods> hairlist = new ArrayList<>();
	private ArrayList<Guest> guestlist = new ArrayList<>();
	private ArrayList<Event> eventlist = new ArrayList<>();
	private JButton btnGuest;
	private Date tiem;
	private JRadioButton rdbtnMember;
	private JRadioButton rdbtnNoMember;
	private int member;
	private static int count = 1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnOrder;
	private hairOrderSearch rigthPanel;
	private JPanel panel_2;

	/**
	 * Create the panel.
	 */
	public hairmanagement() {
		Guest g1 = new Guest(1, "홍길동1", "1990-02-20", "2001-05-10", true, "010-1111-1111");
		Guest g2 = new Guest(2, "홍길동2", "1990-03-30", "2002-06-20", true, "010-2222-2222");
		Hairgoods h1 = new Hairgoods(1, "커트", 1000);
		Hairgoods h2 = new Hairgoods(2, "염색", 2000);
		Event e1 = new Event(1, "생일쿠폰", 0.1);
		Event e2 = new Event(2, "1주년쿠폰", 0.5);

		guestlist.add(g1);
		guestlist.add(g2);
		hairlist.add(h1);
		hairlist.add(h2);
		eventlist.add(e1);
		eventlist.add(e2);
		System.out.println(guestlist);
		System.out.println(hairlist);
		System.out.println(eventlist);

		initComponents();
	}

	private void initComponents() {
		setLayout(new GridLayout(0, 2, 20, 0));
		
		Dimension dim = new Dimension(460,690);
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setPreferredSize(dim);
		//leftPanel.setBounds(0, 0, 460, 690);
		add(leftPanel);
		leftPanel.setLayout(null);
		
		rigthPanel = new hairOrderSearch();
		rigthPanel.setBackground(Color.WHITE);
		rigthPanel.setPreferredSize(dim);
		//rigthPanel.setBounds(0, 460, 920, 690);;
		add(rigthPanel);
		//false로변경
		rigthPanel.setVisible(true);
		rigthPanel.setLayout(null);

		JLabel lblSalesCode = new JLabel("영업 번호");
		lblSalesCode.setBounds(0, 0, 115, 70);
		leftPanel.add(lblSalesCode);
		lblSalesCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesCode.setBackground(Color.WHITE);

		lblSalesCode2 = new JLabel("영업 번호");
		lblSalesCode2.setBounds(115, 0, 115, 70);
		leftPanel.add(lblSalesCode2);
		lblSalesCode2.setForeground(Color.RED);
		lblSalesCode2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesCode2.setBackground(Color.WHITE);

		JLabel lblSalesDay = new JLabel("영업 일자");
		lblSalesDay.setBounds(0, 80, 115, 70);
		leftPanel.add(lblSalesDay);
		lblSalesDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesDay.setBackground(Color.WHITE);

		lblVisitTime2 = new JLabel("방문시간");
		lblVisitTime2.setBounds(345, 80, 115, 70);
		leftPanel.add(lblVisitTime2);
		lblVisitTime2.setForeground(Color.RED);
		lblVisitTime2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitTime2.setBackground(Color.WHITE);
		lblSalesDay2 = new JLabel("영업 일자");
		lblSalesDay2.setBounds(115, 80, 115, 70);
		leftPanel.add(lblSalesDay2);
		
		tiem = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String salesTime = format.format(tiem);
		lblSalesDay2.setText(salesTime);
		lblSalesDay2.setForeground(Color.RED);
		lblSalesDay2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesDay2.setBackground(Color.WHITE);

		JLabel lblVisitTime = new JLabel("방문시간");
		lblVisitTime.setBounds(230, 80, 115, 70);
		leftPanel.add(lblVisitTime);
		lblVisitTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitTime.setBackground(Color.WHITE);

		JLabel lblGuestName = new JLabel("고 객 명");
		lblGuestName.setBounds(0, 160, 115, 70);
		leftPanel.add(lblGuestName);
		lblGuestName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestName.setBackground(Color.WHITE);

		lblGuestCode2 = new JLabel("고객번호");
		lblGuestCode2.setBounds(345, 160, 115, 70);
		leftPanel.add(lblGuestCode2);
		lblGuestCode2.setForeground(Color.RED);
		lblGuestCode2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestCode2.setBackground(Color.WHITE);

		lblGuestName2 = new JLabel("고 객 명");
		lblGuestName2.setBounds(115, 160, 115, 70);
		leftPanel.add(lblGuestName2);
		lblGuestName2.setForeground(Color.RED);
		lblGuestName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestName2.setBackground(Color.WHITE);

		JLabel lblGuestCode = new JLabel("고객번호");
		lblGuestCode.setBounds(230, 160, 115, 70);
		leftPanel.add(lblGuestCode);
		lblGuestCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestCode.setBackground(Color.WHITE);

		JLabel lblHairName = new JLabel("헤 어 명");
		lblHairName.setBounds(0, 240, 115, 70);
		leftPanel.add(lblHairName);
		lblHairName.setHorizontalAlignment(SwingConstants.CENTER);
		lblHairName.setBackground(Color.WHITE);

		lblHairCode2 = new JLabel("헤어번호");
		lblHairCode2.setBounds(345, 240, 115, 70);
		leftPanel.add(lblHairCode2);
		lblHairCode2.setForeground(Color.RED);
		lblHairCode2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHairCode2.setBackground(Color.WHITE);

		JLabel lblHairCode = new JLabel("헤어번호");
		lblHairCode.setBounds(230, 240, 115, 70);
		leftPanel.add(lblHairCode);
		lblHairCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblHairCode.setBackground(Color.WHITE);

		JLabel lblHairPrice = new JLabel("단  가");
		lblHairPrice.setBounds(0, 320, 115, 70);
		leftPanel.add(lblHairPrice);
		lblHairPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblHairPrice.setBackground(Color.WHITE);

		lblEventCode2 = new JLabel("이벤트번호");
		lblEventCode2.setBounds(345, 320, 115, 70);
		leftPanel.add(lblEventCode2);
		lblEventCode2.setForeground(Color.RED);
		lblEventCode2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventCode2.setBackground(Color.WHITE);

		lblHairPrice2 = new JLabel("단  가");
		lblHairPrice2.setBounds(115, 320, 115, 70);
		leftPanel.add(lblHairPrice2);
		lblHairPrice2.setForeground(Color.RED);
		lblHairPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHairPrice2.setBackground(Color.WHITE);

		JLabel lblEventCode = new JLabel("이벤트번호");
		lblEventCode.setBounds(230, 320, 115, 70);
		leftPanel.add(lblEventCode);
		lblEventCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventCode.setBackground(Color.WHITE);

		JLabel lblEventName = new JLabel("이벤트명");
		lblEventName.setBounds(0, 400, 115, 70);
		leftPanel.add(lblEventName);
		lblEventName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventName.setBackground(Color.WHITE);

		lblSale2 = new JLabel("할 인 율");
		lblSale2.setBounds(345, 400, 115, 70);
		leftPanel.add(lblSale2);
		lblSale2.setForeground(Color.RED);
		lblSale2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSale2.setBackground(Color.WHITE);

		JLabel lblSale = new JLabel("할 인 율");
		lblSale.setBounds(230, 400, 115, 70);
		leftPanel.add(lblSale);
		lblSale.setHorizontalAlignment(SwingConstants.CENTER);
		lblSale.setBackground(Color.WHITE);

		JLabel lblPrice = new JLabel("금  액");
		lblPrice.setBounds(0, 480, 115, 70);
		leftPanel.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBackground(Color.WHITE);

		lblPrice2 = new JLabel("금  액");
		lblPrice2.setBounds(115, 480, 115, 70);
		leftPanel.add(lblPrice2);
		lblPrice2.setForeground(Color.RED);
		lblPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice2.setBackground(Color.WHITE);

		btnGuest = new JButton("고객 선택");
		btnGuest.addActionListener(action);
		btnGuest.setBounds(248, 611, 97, 23);
		leftPanel.add(btnGuest);

		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(351, 611, 97, 23);
		leftPanel.add(btnCancel);

		btnOrder = new JButton("주문 하기");
		btnOrder.addActionListener(action);
		btnOrder.setBounds(248, 578, 97, 23);
		leftPanel.add(btnOrder);

		btnOrderCancel = new JButton("임시버튼");
		btnOrderCancel.addActionListener(action);
		btnOrderCancel.setBounds(351, 578, 97, 23);
		leftPanel.add(btnOrderCancel);

		rdbtnMember = new JRadioButton("회원");
		rdbtnMember.setBounds(8, 611, 107, 23);
		leftPanel.add(rdbtnMember);
		rdbtnMember.addActionListener(action);
		buttonGroup.add(rdbtnMember);
		rdbtnMember.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtnNoMember = new JRadioButton("비회원");
		rdbtnNoMember.setBounds(123, 611, 107, 23);
		leftPanel.add(rdbtnNoMember);
		rdbtnNoMember.addActionListener(action);
		buttonGroup.add(rdbtnNoMember);
		rdbtnNoMember.setHorizontalAlignment(SwingConstants.CENTER);
		
		String[] res = ComboHairArray(hairlist);
		comboHair = new JComboBox(res);
		comboHair.setBounds(127, 265, 91, 21);
		leftPanel.add(comboHair);
		comboHair.addActionListener(action);
		comboHair.setSelectedIndex(-1);
		
		String[] res2 = ComboEventArray(eventlist);
		comboEvent = new JComboBox(res2);
		comboEvent.setBounds(127, 425, 91, 21);
		leftPanel.add(comboEvent);
		comboEvent.addActionListener(action);
		comboEvent.setSelectedIndex(-1);

		
		
		

		

		
	}

	private void setGuestPanel(Guest guest) {
		// 고객명, 고객번호 세팅하기
		String name = guest.getGuestName();
		String code = String.valueOf(guest.getGuestCode());

		System.out.println(name + "+" + code);

		lblGuestName2.setText(name);
		lblGuestCode2.setText(code);
	}

	private void setHairPanel(Hairgoods hair) {
		// 헤어번호, 단가 세팅하기
		String code = String.valueOf(hair.getHairCode());
		String price = String.valueOf(hair.getHairPrice());

		System.out.println(code + "+" + price);

		lblHairCode2.setText(code);
		lblHairPrice2.setText(price);
	}

	private void setEventPanel(Event event) {
		// 이벤트번호, 이벤트 할인율 셋팅
		String code = String.valueOf(event.getEventcode());
		String sale = String.valueOf(String.format("%.1f", event.getEventsale()));

		System.out.printf("%d + %f", code, sale);

		lblEventCode2.setText(code);
		lblSale2.setText(sale);
	}

	ActionListener action = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnGuest) {
				actionPerformedBtnGuest(e);
				
				//고객선택하고 돌아왔을때
				PanelGuestSeting();
			}

			if (e.getSource() == comboHair) {
				hairPanelSet();
			}
			
			if (e.getSource() == comboEvent) {
				eventPanelSet();
			}

			if (e.getSource() instanceof JRadioButton) {
				if (e.getActionCommand() == "회원") {
					System.out.println("회원");
					member = 1;
				} else {
					System.out.println("비회원");
					member = 0;
					
				}
			}
			if(e.getSource() == btnOrder) {
				order();
			}
			if(e.getSource() == btnOrderCancel) {
				orderSreachInfo();
			}

		}

		private void orderSreachInfo() {
			
			rigthPanel.setVisible(true);
		}

		private void order() {
			int scode = Integer.parseInt(lblSalesCode2.getText().trim());
			String sdate = lblSalesDay2.getText().trim();
			
			String gname = lblGuestName2.getText().trim();
			String hname = comboHair.getSelectedItem().toString();
			
			String ename = comboEvent.getSelectedItem().toString();
			int totalpirce = Integer.parseInt(lblPrice2.getText().trim());
			
			Sales s = new Sales(scode,sdate, gname, hname, ename, totalpirce);
			
			rigthPanel.orderSreachset(s);
			count++;
			lblSalesCode2.setText(String.valueOf(count));
		
		}

		private void hairPanelSet() {
			if (comboHair.getSelectedIndex() != -1) {
				String res = comboHair.getSelectedItem().toString();
				System.out.println(res);
				System.out.println("콤보헤어");

				PanelHairSeting(res);
				
				if(comboEvent.getSelectedIndex() != -1) {
					totalPrice();
				}

			}
		}

		private void eventPanelSet() {
			if (comboEvent.getSelectedIndex() != -1) {
				String res = comboEvent.getSelectedItem().toString();
				System.out.println(res);
				System.out.println("콤보이벤트");
				
				PanelEventSeting(res);
				
				if(comboHair.getSelectedIndex() != -1) {
					totalPrice();
				}

				
			}
		}

		private void totalPrice() {
			int hp = Integer.parseInt(lblHairPrice2.getText().trim());
			double es = Double.parseDouble(lblSale2.getText().trim());
			
			int salesnum =  (int) (hp * es);
			
			lblPrice2.setText(String.valueOf(hp-salesnum));
		}

		private void PanelEventSeting(String res) {
			Event e = new Event();
			for(Event elist : eventlist) {
				if(res.equals(elist.getEventname())) {
					lblEventCode2.setText(String.valueOf(elist.getEventcode()));
					lblSale2.setText(String.valueOf(elist.getEventsale()));
					
					
				}
			}
			
		}

		private void PanelHairSeting(String res) {
			Hairgoods h = new Hairgoods();
			for(Hairgoods hlist : hairlist) {
				if(res.equals(hlist.getHairName())) {
					lblHairCode2.setText(String.valueOf(hlist.getHairCode()));
					lblHairPrice2.setText(String.valueOf(hlist.getHairPrice()));
				}
			}
			
		}

		private void PanelGuestSeting() {
			
			//일단 게스트를 받았다고 설정
			Guest g1 = new Guest(1, "홍길동1", "1990-02-20", "2001-05-10", true, "010-1111-1111");
			
			
			String name = g1.getGuestName();
			String code = String.valueOf(g1.getGuestCode());
			
			lblGuestName2.setText(name);
			lblGuestCode2.setText(code);
			
		}
	};


	private JButton btnOrderCancel;	protected void actionPerformedBtnGuest(ActionEvent arg0) {
		// 고객 검색에서 고객정보를불러옴
		tiem = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH : mm");
		String visitTime = format.format(tiem);
		lblVisitTime2.setText(visitTime);

		//라디오 버튼 실험
		setEnabledRadio();
		//guest 버튼 실험
		//setOutGuestSreach();

		lblSalesCode2.setText(String.valueOf(count));

	}

	private String[] ComboHairArray(ArrayList<Hairgoods> list) {
		String[] res = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i).getHairName();
		}
		return res;
	}

	private String[] ComboEventArray(ArrayList<Event> list) {
		String[] res = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i).getEventname();
		}
		return res;
	}

	private void setEnabledRadio() {
		rdbtnMember.setSelected(true);
		rdbtnMember.setEnabled(false);
		rdbtnNoMember.setEnabled(false);

	}

	private void setOutGuestSreach() {
		btnGuest.setVisible(false);

	}

}
