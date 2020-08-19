package hairrang.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import hairrang.dto.Guest;
import hairrang.exception.EmptyTfException;
import hairrang.table.GuestSearchTable;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class GuestSearchPanel extends JPanel {
	private JPanel panel;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblCode;
	private JTextField tfCode;
	private JLabel lblBirthday;
	private JTextField tfBirthday;
	private JLabel lblJoinday;
	private JTextField tfJoinday;
	private JLabel lblGender;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JButton btnSearch;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JRadioButton rbBtnFamale;
	private JRadioButton rbBtnMale;
	private ButtonGroup rbBtnGroup;
	private GuestSearchTable table;
	private DefaultTableModel model;
	private ArrayList<Guest> guestList;

	/**
	 * Create the panel.
	 */

	public GuestSearchPanel() {

		guestList = new ArrayList<Guest>();
		guestList.add(new Guest(1, "고연정", "1990-02-20", "2001-05-10", true, "010-1234-1234"));
		guestList.add(new Guest(2, "김연지", "1992-09-09", "2000-03-02", false, "010-2234-2344"));
		guestList.add(new Guest(3, "이나라", "1987-06-01", "2001-08-08", true, "010-1464-1564"));
		guestList.add(new Guest(4, "최순호", "1990-06-01", "2001-08-02", false, "010-6744-1634"));
		guestList.add(new Guest(5, "최순호", "1990-05-05", "2000-05-10", true, "010-2344-2434"));

		initComponents();

	}

	private void initComponents() {
		setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setBounds(0, 0, 460, 240);
		add(panel);
		panel.setLayout(null);

		lblName = new JLabel("고 객 명 : ");
		lblName.setBounds(37, 11, 133, 28);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblName);

		tfName = new JTextField();
		tfName.setBounds(184, 11, 133, 28);
		tfName.setColumns(10);
		panel.add(tfName);

		btnSearch = new JButton("검색");

		
		btnSearch.setBounds(331, 11, 70, 28);
		panel.add(btnSearch);

		lblCode = new JLabel("고객번호 : ");
		lblCode.setBounds(37, 50, 133, 28);
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblCode);

		tfCode = new JTextField();
		tfCode.setBounds(184, 49, 133, 28);
		tfCode.setColumns(10);

		// documentlistener
		// tfName.getDocument().addDocumentListener(docListener);
		panel.add(tfCode);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(316, 49, 133, 28);
		panel.add(lblNewLabel);

		lblBirthday = new JLabel("생년월일 : ");
		lblBirthday.setBounds(37, 89, 133, 28);
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblBirthday);

		tfBirthday = new JTextField();
		tfBirthday.setBounds(184, 87, 133, 28);
		tfBirthday.setColumns(10);
		panel.add(tfBirthday);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(316, 87, 133, 28);
		panel.add(lblNewLabel_1);

		lblJoinday = new JLabel("가입일자 : ");
		lblJoinday.setBounds(37, 126, 133, 28);
		lblJoinday.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblJoinday);

		tfJoinday = new JTextField();
		tfJoinday.setBounds(184, 126, 133, 28);
		tfJoinday.setColumns(10);

		panel.add(tfJoinday);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(316, 125, 133, 28);
		panel.add(lblNewLabel_2);

		lblGender = new JLabel("성      별 : ");
		lblGender.setBounds(37, 165, 133, 28);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblGender);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(316, 163, 133, 28);
		panel.add(lblNewLabel_3);

		lblPhone = new JLabel("연 락 처 : ");
		lblPhone.setBounds(37, 204, 133, 28);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblPhone);

		tfPhone = new JTextField();
		tfPhone.setBounds(184, 204, 133, 28);
		tfPhone.setColumns(10);
		panel.add(tfPhone);

		// 라디오버튼 그룹

		rbBtnGroup = new ButtonGroup();

		rbBtnFamale = new JRadioButton("여성");
		rbBtnFamale.setLocation(184, 164);
		rbBtnFamale.setSize(60, 30);

		rbBtnMale = new JRadioButton("남성");
		rbBtnMale.setLocation(250, 164);
		rbBtnMale.setSize(60, 30);

		rbBtnGroup.add(rbBtnFamale);
		rbBtnGroup.add(rbBtnMale);

		panel.add(rbBtnFamale);
		panel.add(rbBtnMale);
		
		
	}

	

// get set clear///////////////////////////////////////////////////////////////////////////////////////////////

	private Guest getselectedGuest() {
		int selectedRow = table.getSelectedRow();
		return guestList.get(selectedRow);
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
		boolean guestGender = rbBtnFamale.isSelected() ? true : false;
		String guestPhone = tfPhone.getText().trim();
		return new Guest(guestCode, guestName, guestBirthday, guestJoinday, guestGender, guestPhone);
	}

	public void setGuest(Guest guest) {
		tfCode.setText(String.valueOf(guest.getGuestCode()));
		tfName.setText(guest.getGuestName());
		tfBirthday.setText(guest.getGuestBirthday());
		tfJoinday.setText(guest.getGuestJoinday());
		if (guest.getGuestGender() == true) {
			rbBtnFamale.setSelected(true);
		} else {
			rbBtnMale.setSelected(true);
		}

//			comboBox.setSelectedItem(guest.getGuestGender());
//				if (guest.getGuestGender() == true) {
//					comboBox.setSelectedIndex(1);
//				} else {
//					comboBox.setSelectedIndex(2);
//				}
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

//예외 //////////////////////////////////////////////////////////////////////////////////////////////////////

	private boolean isEmpty() {
		return tfCode.getText().isEmpty() || tfName.getText().isEmpty() || tfBirthday.getText().isEmpty()
				|| tfJoinday.getText().isEmpty() || rbBtnGroup.isSelected(null) || tfPhone.getText().isEmpty();
		// comboBox.getSelectedIndex() == 0
	}
}
