package hairrang.component;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import hairrang.dto.Guest;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class GuestSearch extends JPanel implements ActionListener {
	private JPanel pBtns;
	private JPanel pTable;
	private JButton btnHairInfo;
	private JButton btnHairOrder;
	private JButton btnCancel;
	private JPanel pLeft;
	private JLayeredPane layeredPane;
	private HairInfo pHairInfo;
	private JPanel pHairOrder;
	private JPanel pGuest;
	private JLabel lblName;

	private JTextField tfName;
	private JScrollPane scrollPane;
	private JTable table;

	private ArrayList<Guest> guestList;
	private DefaultTableModel model;
	private TableRowSorter<TableModel> rowSorter;
	private JButton pSearch;
	private JLabel lblCode;
	private JTextField tfCode;
	private JLabel label_em;
	private JLabel lblBirthday;
	private JTextField tfBirthday;
	private JLabel label_4;
	private JLabel lblJoinday;
	private JTextField tfJoinday;
	private JLabel label_6;
	private JLabel lblGender;
	private JLabel label_8;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JRadioButton rbBtnFemale;
	private JRadioButton rbBtnMale;
	private final ButtonGroup rbBtnGroup = new ButtonGroup();
	private JPanel pEmpty;


	public GuestSearch() {

		guestList = new ArrayList<Guest>();
		guestList.add(new Guest(1, "고연정", "1990-02-20", "2001-05-10", true, "010-1234-1234"));
		guestList.add(new Guest(2, "김연지", "1992-09-09", "2000-03-02", false, "010-2234-2344"));
		guestList.add(new Guest(3, "이나라", "1987-06-01", "2001-08-08", true, "010-1464-1564"));
		guestList.add(new Guest(4, "최순호", "1990-06-01", "2001-08-02", false, "010-6744-1634"));
		guestList.add(new Guest(5, "최순호", "1990-05-05", "2000-05-10", true, "010-2344-2434"));
		guestList.add(new Guest(6, "최순호순호", "1990-05-05", "2000-05-10", true, "010-2344-2434"));

		initComponents();

	}

	private void initComponents() {
		model = new DefaultTableModel(getRows(guestList), getColNames());
		setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(480, 0, 460, 690);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		pEmpty = new JPanel();
		pEmpty.setVisible(false);
		layeredPane.add(pEmpty, "name_1412628163830900");

		pHairInfo = new HairInfo();
		pHairInfo.setVisible(false);
		layeredPane.add(pHairInfo, "name_1646642091984600");
		pHairInfo.setLayout(null);

		pHairOrder = new JPanel();
		pHairOrder.setVisible(false);
		layeredPane.add(pHairOrder, "name_1646642099806600");
		pHairOrder.setLayout(new GridLayout(1, 0, 0, 0));
		
//		if(layeredPane.isDisplayable() && pLeft.isDisplayable()) {
//			layeredPane.revalidate();
//			layeredPane.repaint();
//		}

		pLeft = new JPanel();
		pLeft.setBounds(0, 0, 460, 690);
		add(pLeft);
		pLeft.setLayout(null);

		pGuest = new JPanel();
		pGuest.setBounds(0, 0, 460, 240);
		pLeft.add(pGuest);
		pGuest.setLayout(null);

		lblName = new JLabel("고 객 명 : ");
		lblName.setBounds(113, 10, 133, 28);
		pGuest.add(lblName);

		tfName = new JTextField();
		tfName.setBounds(183, 11, 133, 28);
		pGuest.add(tfName);
		tfName.setColumns(10);

		pSearch = new JButton("일단안씀");
		pSearch.setBounds(330, 10, 86, 28);
		pGuest.add(pSearch);

		lblCode = new JLabel("고객번호 : ");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCode.setBounds(36, 49, 133, 28);
		pGuest.add(lblCode);

		tfCode = new JTextField();
		tfCode.setColumns(10);
		tfCode.setBounds(183, 48, 133, 28);
		pGuest.add(tfCode);

		label_em = new JLabel("");
		label_em.setBounds(315, 48, 133, 28);
		pGuest.add(label_em);

		lblBirthday = new JLabel("생년월일 : ");
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthday.setBounds(36, 88, 133, 28);
		pGuest.add(lblBirthday);

		tfBirthday = new JTextField();
		tfBirthday.setColumns(10);
		tfBirthday.setBounds(183, 86, 133, 28);
		pGuest.add(tfBirthday);

		label_4 = new JLabel("");
		label_4.setBounds(315, 86, 133, 28);
		pGuest.add(label_4);

		lblJoinday = new JLabel("가입일자 : ");
		lblJoinday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJoinday.setBounds(36, 125, 133, 28);
		pGuest.add(lblJoinday);

		tfJoinday = new JTextField();
		tfJoinday.setColumns(10);
		tfJoinday.setBounds(183, 125, 133, 28);
		pGuest.add(tfJoinday);

		label_6 = new JLabel("");
		label_6.setBounds(315, 124, 133, 28);
		pGuest.add(label_6);

		lblGender = new JLabel("성      별 : ");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(36, 164, 133, 28);
		pGuest.add(lblGender);

		label_8 = new JLabel("");
		label_8.setBounds(315, 162, 133, 28);
		pGuest.add(label_8);

		lblPhone = new JLabel("연 락 처 : ");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(36, 203, 133, 28);
		pGuest.add(lblPhone);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(183, 203, 133, 28);
		pGuest.add(tfPhone);

		rbBtnFemale = new JRadioButton("여성");
		rbBtnGroup.add(rbBtnFemale);
		rbBtnFemale.setBounds(190, 162, 60, 30);
		pGuest.add(rbBtnFemale);

		rbBtnMale = new JRadioButton("남성");
		rbBtnGroup.add(rbBtnMale);
		rbBtnMale.setBounds(256, 162, 60, 30);
		pGuest.add(rbBtnMale);
		tfName.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfName.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfName.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}

		});

		pBtns = new JPanel();
		pBtns.setBounds(0, 240, 460, 35);
		pLeft.add(pBtns);
		pBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnHairInfo = new JButton("고객헤어정보");
		btnHairInfo.addActionListener(this);
		pBtns.add(btnHairInfo);
		btnHairOrder = new JButton("헤어주문");
		btnHairOrder.addActionListener(this);
		pBtns.add(btnHairOrder);


		btnCancel = new JButton("취      소");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearTf();

			}
		});
		pBtns.add(btnCancel);

		pTable = new JPanel();
		pTable.setBounds(0, 275, 460, 413);
		pLeft.add(pTable);
		pTable.setLayout(new GridLayout(1, 0, 0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 275, 460, 413);
		pTable.add(scrollPane);

		table = new JTable(model);
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					Guest selectedGuest = getselectedGuest();
					//클릭했을때 문제 
					//검색해서 클릭하면 filter는 보여만 줄 뿐 인덱스는 깔려있어서 인덱스의 정보가 반환됨
					setGuest(selectedGuest);

				}
			}

		});
		
		

	}

	
	public void setLayeredPane(boolean a) {
	      this.layeredPane.setVisible(a);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//테이블

	private Object[][] getRows(ArrayList<Guest> guestList) {
		Object[][] rows = new Object[guestList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(guestList.get(i));
		}
		return rows;

	}

	public Object[] getColNames() {
		return new String[] { "고객번호", "고객명", "생년월일", "가입일자", "성별", "전화번호" };
	}

	private Object[] toArray(Guest guest) {
		return new Object[] { guest.getGuestCode(), guest.getGuestName(), guest.getGuestBirthday(),
				guest.getGuestJoinday(), guest.getGuestGender() == true ? "여" : "남", guest.getGuestPhone() };
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//패널 

	private Guest getselectedGuest() {
		int selectedRow = table.getSelectedRow();

		int code = (int) table.getValueAt(selectedRow, 0);
		String name = (String) table.getValueAt(selectedRow, 1);
		String birth = (String) table.getValueAt(selectedRow, 2);
		String join = (String) table.getValueAt(selectedRow, 3);
		String gender_str = (String) table.getValueAt(selectedRow, 4);
		boolean gender = gender_str.equals("여") ? true : false;
		String phone = (String) table.getValueAt(selectedRow, 5);

		return new Guest(code, name, birth, join, gender, phone);

	}

	public Guest getGuest() {

		//if (isEmpty()) {
		//	JOptionPane.showMessageDialog(null, "공란 존재", "오류", JOptionPane.ERROR_MESSAGE);
		//	throw new EmptyTfException("공란 존재");
		//}

		int guestCode = Integer.parseInt(tfCode.getText().trim());
		String guestName = tfName.getText().trim();
		String guestBirthday = tfBirthday.getText().trim();
		String guestJoinday = tfJoinday.getText().trim();
		// boolean guestGender = comboBox.getSelectedIndex() == 1 ? true : false;
		boolean guestGender = rbBtnFemale.isSelected() ? true : false;
		String guestPhone = tfPhone.getText().trim();
		return new Guest(guestCode, guestName, guestBirthday, guestJoinday, guestGender, guestPhone);
	}

	public void setGuest(Guest guest) {
		tfCode.setText(String.valueOf(guest.getGuestCode()));
		tfName.setText(guest.getGuestName());
		tfBirthday.setText(guest.getGuestBirthday());
		tfJoinday.setText(guest.getGuestJoinday());
		if (guest.getGuestGender() == true) {
			rbBtnFemale.setSelected(true);
		} else {
			rbBtnMale.setSelected(true);
		}

		//				comboBox.setSelectedItem(guest.getGuestGender());
		//					if (guest.getGuestGender() == true) {
		//						comboBox.setSelectedIndex(1);
		//					} else {
		//						comboBox.setSelectedIndex(2);
		//					}
		tfPhone.setText(guest.getGuestPhone());
	}

	public void clearTf() {
		tfCode.setText("");
		tfName.setText("");
		tfBirthday.setText("");
		tfJoinday.setText("");
		rbBtnGroup.clearSelection();
		// comboBox.setSelectedIndex(0);
		tfPhone.setText("");
	}

	private boolean isEmpty() {
		return tfCode.getText().isEmpty() || tfName.getText().isEmpty() || tfBirthday.getText().isEmpty()
				|| tfJoinday.getText().isEmpty() || rbBtnGroup.isSelected(null) || tfPhone.getText().isEmpty();
		// comboBox.getSelectedIndex() == 0
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHairOrder) {
			btnHairOrderActionPerformed(e);
		}
		if (e.getSource() == btnHairInfo) {
			btnHairInfoActionPerformed(e);
		}
	}
	

	// 헤어정보 버튼
	protected void btnHairInfoActionPerformed(ActionEvent e) {
		switchPanels(pHairInfo);
	}
	
	// 헤어주문 버튼
	protected void btnHairOrderActionPerformed(ActionEvent e) {
		switchPanels(pHairOrder);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.setVisible(true);
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
