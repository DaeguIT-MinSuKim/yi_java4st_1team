package hairrang.testUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import hairrang.dto.Guest;
import hairrang.service.GuestService;
import com.toedter.calendar.JDateChooser;

public class GuestManagementPanel extends JPanel {
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfJoinDay;
	private JTextField tfPhone;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rBtnFemale;
	private JRadioButton rBtnMale;
	private JTextField tfMemo;
	private GuestService gService;
	private JDateChooser dateChooser;

	/**
	 * Create the panel.
	 */
	public GuestManagementPanel() {
		setLayout(null);

		JLabel lblNo = new JLabel("고객 번호 : ");
		lblNo.setBounds(68, 30, 70, 15);
		add(lblNo);

		tfNo = new JTextField();
		tfNo.setBounds(153, 27, 116, 25);
		add(tfNo);
		tfNo.setColumns(10);
		tfNo.setEditable(false);

		JLabel lblName = new JLabel("고  객  명 : ");
		lblName.setBounds(68, 67, 70, 15);
		add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(153, 62, 116, 25);
		add(tfName);

		JLabel lblBirthday = new JLabel("생년월일  : ");
		lblBirthday.setBounds(68, 102, 70, 15);
		add(lblBirthday);

		JLabel lblJoinDay = new JLabel("가입일자  : ");
		lblJoinDay.setBounds(68, 135, 70, 15);

		add(lblJoinDay);

		tfJoinDay = new JTextField();
		tfJoinDay.setColumns(10);
		tfJoinDay.setBounds(153, 132, 116, 25);
		tfJoinDay.setEditable(false);
		add(tfJoinDay);

		JLabel lblGender = new JLabel("성       별 : ");
		lblGender.setBounds(368, 28, 70, 15);
		add(lblGender);

		JLabel lblPhone = new JLabel("연  락  처 : ");
		lblPhone.setBounds(368, 65, 70, 15);
		add(lblPhone);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(446, 62, 116, 25);
		add(tfPhone);

		JLabel lblMemo = new JLabel("메      모  : ");
		lblMemo.setBounds(368, 102, 70, 15);
		add(lblMemo);

		rBtnFemale = new JRadioButton("여성");
		buttonGroup.add(rBtnFemale);
		rBtnFemale.setBounds(446, 27, 60, 23);
		add(rBtnFemale);

		rBtnMale = new JRadioButton("남성");
		buttonGroup.add(rBtnMale);
		rBtnMale.setBounds(510, 27, 60, 23);
		add(rBtnMale);

		tfMemo = new JTextField();
		tfMemo.setBounds(446, 99, 116, 21);
		add(tfMemo);
		tfMemo.setColumns(10);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		Date date = new Date();
		dateChooser.setDate(date);
		dateChooser.setBounds(153, 96, 116, 21);
		add(dateChooser);

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

	public void setTfNo(JTextField tfNo) {
		this.tfNo = tfNo;
		
	}

	// 오늘날짜 셋
	public void setTfJoinDay() {
		Date date = new Date();
		tfJoinDay.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
	}

	public void setTfNo(int curr) {
		tfNo.setText(String.valueOf(curr));

	}

}
