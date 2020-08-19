package yi_java4st_1team.component;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import yi_java4st_1team.dto.Guest;
import yi_java4st_1team.exception.EmptyTfException;

import javax.swing.JRadioButton;

public class GuestManagementPanel extends JPanel {
	private JLabel lblCode;
	private JTextField tfCode;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblBirthday;
	private JTextField tfBirthday;
	private JLabel lblJoinday;
	private JTextField tfJoinday;
	private JLabel lblGender;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JPanel panel;
	private JRadioButton rbBtnFamale;
	private JRadioButton rbBtnMale;
	private ButtonGroup rbBtnGroup;

	/**
	 * Create the panel.
	 */
	public GuestManagementPanel() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 50, 20, 10));
		panel.setBounds(0, 0, 450, 240);
		add(panel);
		panel.setLayout(null);

		lblCode = new JLabel("고객번호 : ");
		lblCode.setBounds(60, 10, 133, 28);
		panel.add(lblCode);
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);

		tfCode = new JTextField();
		tfCode.setBounds(207, 10, 133, 28);
		panel.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(333, 10, 106, 20);
		panel.add(label);

		lblName = new JLabel("고 객 명 :  ");
		lblName.setBounds(60, 49, 133, 28);
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);

		tfName = new JTextField();
		tfName.setBounds(207, 50, 133, 28);
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(333, 50, 106, 20);
		panel.add(label_1);

		lblBirthday = new JLabel("생년월일 : ");
		lblBirthday.setBounds(60, 88, 133, 28);
		panel.add(lblBirthday);
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);

		tfBirthday = new JTextField();
		tfBirthday.setBounds(207, 90, 133, 28);
		panel.add(tfBirthday);
		tfBirthday.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(333, 90, 106, 20);
		panel.add(label_2);

		lblJoinday = new JLabel("가입일자 : ");
		lblJoinday.setBounds(60, 130, 133, 28);
		panel.add(lblJoinday);
		lblJoinday.setHorizontalAlignment(SwingConstants.RIGHT);

		tfJoinday = new JTextField();
		tfJoinday.setBounds(207, 130, 133, 28);
		//tfJoinday.setText(String.valueOf(new Date()));
		panel.add(tfJoinday);
		tfJoinday.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(333, 130, 106, 20);
		panel.add(label_3);

		lblGender = new JLabel("성      별 : ");
		lblGender.setBounds(60, 170, 133, 28);
		panel.add(lblGender);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);

		lblPhone = new JLabel("연 락 처 : ");
		lblPhone.setBounds(60, 210, 133, 28);
		panel.add(lblPhone);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);

		tfPhone = new JTextField();
		tfPhone.setBounds(207, 210, 133, 28);
		panel.add(tfPhone);
		tfPhone.setColumns(10);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(333, 210, 106, 20);
		panel.add(label_4);
		
		//라디오버튼 그룹
		rbBtnFamale = new JRadioButton("여성");
		rbBtnFamale.setLocation(206, 169);
		rbBtnFamale.setSize(60, 30);
		
		rbBtnMale = new JRadioButton("남성");
		rbBtnMale.setLocation(280, 169);
		rbBtnMale.setSize(60, 30);
		
		rbBtnGroup = new ButtonGroup(); //같은그룹끼리는 하나만 선택됨
		rbBtnGroup.add(rbBtnFamale);
		rbBtnGroup.add(rbBtnMale);
		
		panel.add(rbBtnFamale);
		panel.add(rbBtnMale);
		
		
		

	}

// get set clear///////////////////////////////////////////////////////////////////////////////////////////////

	public Guest getGuest() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "공란 존재", "오류", JOptionPane.ERROR_MESSAGE);
			throw new EmptyTfException("공란 존재");
		}

		int guestCode = Integer.parseInt(tfCode.getText().trim());
		String guestName = tfName.getText().trim();
		String guestBirthday = tfBirthday.getText().trim();
		String guestJoinday = tfJoinday.getText().trim();
		//boolean guestGender = comboBox.getSelectedIndex() == 1 ? true : false;
		boolean guestGender = rbBtnFamale.isSelected()? true:false;
		String guestPhone = tfPhone.getText().trim();
		return new Guest(guestCode, guestName, guestBirthday, guestJoinday, guestGender, guestPhone);
	}

	public void setGuest(Guest guest) {
		tfCode.setText(String.valueOf(guest.getGuestCode()));
		tfName.setText(guest.getGuestName());
		tfBirthday.setText(guest.getGuestBirthday());
		tfJoinday.setText(guest.getGuestJoinday());
		if(guest.getGuestGender() == true) {
			rbBtnFamale.setSelected(true);
		}else {
			rbBtnMale.setSelected(true);
		}
	
//		comboBox.setSelectedItem(guest.getGuestGender());
//			if (guest.getGuestGender() == true) {
//				comboBox.setSelectedIndex(1);
//			} else {
//				comboBox.setSelectedIndex(2);
//			}
		tfPhone.setText(guest.getGuestPhone());
	}

	public void clearTf() {
		tfCode.setText("");
		tfName.setText("");
		tfBirthday.setText("");
		tfJoinday.setText("");
		rbBtnGroup.clearSelection();
		//comboBox.setSelectedIndex(0);
		tfPhone.setText("");
	}

//예외 //////////////////////////////////////////////////////////////////////////////////////////////////////

	private boolean isEmpty() {
		return tfCode.getText().isEmpty() || tfName.getText().isEmpty() || tfBirthday.getText().isEmpty()
				|| tfJoinday.getText().isEmpty() || rbBtnGroup.isSelected(null) || tfPhone.getText().isEmpty();
		//comboBox.getSelectedIndex() == 0
	}
}
