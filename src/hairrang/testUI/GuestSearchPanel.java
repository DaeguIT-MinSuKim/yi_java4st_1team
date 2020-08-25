package hairrang.testUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import hairrang.dto.Guest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestSearchPanel extends JPanel implements ActionListener {
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfJoinDay;
	private JTextField tfPhone;
	private JTextField tfMemo;
	private JLabel lblNo;
	private JLabel lblName;
	private JLabel lblBirthday;
	private JLabel lblJoinDay;
	private JLabel lblGender;
	private JLabel lblPhone;
	private JLabel lblNote;
	private JRadioButton rBtnFemale;
	private JRadioButton rBtnMale;
	private JDateChooser dateChooser;
	private JButton btnSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public GuestSearchPanel() {
		setLayout(null);
		
		lblNo = new JLabel("고객 번호 : ");
		lblNo.setBounds(82, 73, 70, 15);
		add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setEditable(false);
		tfNo.setColumns(10);
		tfNo.setBounds(167, 64, 116, 25);
		add(tfNo);
		
		lblName = new JLabel("고  객  명 : ");
		lblName.setBounds(82, 37, 70, 15);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(167, 32, 116, 25);
		add(tfName);
		
		lblBirthday = new JLabel("생년월일  : ");
		lblBirthday.setBounds(82, 109, 70, 15);
		add(lblBirthday);
		
		lblJoinDay = new JLabel("가입일자  : ");
		lblJoinDay.setBounds(82, 142, 70, 15);
		add(lblJoinDay);
		
		tfJoinDay = new JTextField();
		tfJoinDay.setEditable(false);
		tfJoinDay.setColumns(10);
		tfJoinDay.setBounds(167, 139, 116, 25);
		add(tfJoinDay);
		
		lblGender = new JLabel("성       별 : ");
		lblGender.setBounds(382, 35, 70, 15);
		add(lblGender);
		
		lblPhone = new JLabel("연  락  처 : ");
		lblPhone.setBounds(382, 72, 70, 15);
		add(lblPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(460, 69, 116, 25);
		add(tfPhone);
		
		lblNote = new JLabel("메      모  : ");
		lblNote.setBounds(382, 109, 70, 15);
		add(lblNote);
		
		rBtnFemale = new JRadioButton("여성");
		buttonGroup.add(rBtnFemale);
		rBtnFemale.setBounds(460, 34, 60, 23);
		add(rBtnFemale);
		
		rBtnMale = new JRadioButton("남성");
		buttonGroup.add(rBtnMale);
		rBtnMale.setBounds(524, 34, 60, 23);
		add(rBtnMale);
		
		tfMemo = new JTextField();
		tfMemo.setColumns(10);
		tfMemo.setBounds(460, 106, 116, 25);
		add(tfMemo);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(167, 103, 116, 25);
		add(dateChooser);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(295, 33, 71, 23);
		add(btnSearch);

	}
	
	
	public Guest getGuest() throws ParseException {

		Calendar c = Calendar.getInstance();
		Date join = new Date(c.getTimeInMillis());

		// string->date
		int guestNo = Integer.parseInt(tfNo.getText().trim());
		String guestName = tfName.getText().trim();
		Date birthday = dateChooser.getDate();
		Date joinDay = join;
		String phone = tfPhone.getText().trim();
		int gender = rBtnFemale.isSelected() ? 1 : 2;
		String guestNote = tfMemo.getText().trim();
		return new Guest(guestNo, guestName, birthday, joinDay, phone, gender, guestNote);

	}

	// 패널셋 date->string
	public void setGuest(Guest guest) {
		tfNo.setText(String.valueOf(guest.getGuestNo()));
		tfName.setText(guest.getGuestName());
		tfJoinDay.setText(new SimpleDateFormat("yyyy-MM-dd").format(guest.getJoinDay()));
		tfPhone.setText(guest.getPhone());
		dateChooser.setDate(guest.getBirthday());

		if (guest.getGender() == 1) {
			rBtnFemale.setSelected(true);
		} else {
			rBtnMale.setSelected(true);
		}
		tfMemo.setText(guest.getGuestNote());

	}

	public void clearTf() {
		tfName.setText("");
		
		Date date = new Date();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setDate(date);
		
		tfJoinDay.setText("");
		tfPhone.setText("");
		buttonGroup.clearSelection();
		tfMemo.setText("");

	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSearch) {
			btnSearchActionPerformed(e);
		}
	}


	private void btnSearchActionPerformed(ActionEvent e) {
		System.out.println("검색");
		
	}

}
