package yi_java4st_1team.component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import yi_java4st_1team.dto.Guest;

public class HairInfoPanel extends JPanel {
	private JPanel pHairInfo;
	private JLabel lblCode;
	private JTextField tfCode;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblBirthday;
	private JTextField tfBirthday;

	public HairInfoPanel() {
		setLayout(null);
		
		setBorder(new EmptyBorder(10, 10, 10, 100));
		setBounds(0, 0, 460, 140);
		
		lblCode = new JLabel("고객번호 : ");
		lblCode.setBounds(10, 11, 165, 28);
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblCode);
		
		tfCode = new JTextField();
		tfCode.setBounds(189, 11, 133, 28);
		add(tfCode);
		tfCode.setColumns(10);
		
		lblName = new JLabel("고 객 명 : ");
		lblName.setBounds(10, 50, 165, 28);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(189, 50, 133, 28);
		add(tfName);
		tfName.setColumns(10);
		
		lblBirthday = new JLabel("생년월일 : ");
		lblBirthday.setBounds(10, 89, 165, 28);
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblBirthday);
		
		tfBirthday = new JTextField();
		tfBirthday.setBounds(189, 89, 133, 28);
		tfBirthday.setText("번호추가할까말까");
		tfBirthday.setColumns(10);
		add(tfBirthday);

	}
	
	//get set clear
//	private Guest getselectedGuest() {
//		int selectedRow = table.getSelectedRow();
//		return guestList.get(selectedRow);
//	}

	public Guest getGuest() {
		
		//if (isEmpty()) {
		//	JOptionPane.showMessageDialog(null, "공란 존재", "오류", JOptionPane.ERROR_MESSAGE);
		//	throw new EmptyTfException("공란 존재");
		//}

		int guestCode = Integer.parseInt(tfCode.getText().trim());
		String guestName = tfName.getText().trim();
		String guestBirthday = tfBirthday.getText().trim();
		
		return new Guest(guestCode, guestName, guestBirthday);
	}

	public void setGuest(Guest guest) {
		tfCode.setText(String.valueOf(guest.getGuestCode()));
		tfName.setText(guest.getGuestName());
		tfBirthday.setText(guest.getGuestBirthday());
		

//			comboBox.setSelectedItem(guest.getGuestGender());
//				if (guest.getGuestGender() == true) {
//					comboBox.setSelectedIndex(1);
//				} else {
//					comboBox.setSelectedIndex(2);
//				}
		
	}
	
	
}
