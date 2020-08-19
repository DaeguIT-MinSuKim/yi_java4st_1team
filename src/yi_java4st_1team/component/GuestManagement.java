package yi_java4st_1team.component;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import yi_java4st_1team.dto.Guest;
import yi_java4st_1team.table.GuestManagementTable;

@SuppressWarnings("serial")
public class GuestManagement extends JPanel {
	private JPanel pTable;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnCancel;

	private GuestManagementPanel pGuest;
	private JScrollPane scrollPane;
	private GuestManagementTable table;
	private ArrayList<Guest> guestList;

	/**
	 * Create the panel.
	 */
	public GuestManagement() {
		guestList = new ArrayList<Guest>();
		guestList.add(new Guest(1, "고연정", "1990-02-20", "2001-05-10", true, "010-1234-1234"));
		guestList.add(new Guest(2, "김연지", "1992-09-09", "2000-03-02", false, "010-2234-2344"));
		guestList.add(new Guest(3, "이나라", "1987-06-01", "2001-08-08", true, "010-1464-1564"));
		guestList.add(new Guest(4, "최순호", "1990-06-01", "2001-08-02", false, "010-6744-1634"));
		guestList.add(new Guest(5, "최순호", "1990-05-05", "2000-05-10", true, "010-2344-2434"));
		guestList.add(new Guest(5, "최순호순호", "1990-05-05", "2000-05-10", true, "010-2344-2434"));

		initComponents();

		//Guest test = new Guest(1, "김혜진", "1990-02-20", "2001-05-10", false, "010-1234-1234");
		//pGuest.setGuest(test);

	}

	private void initComponents() {

		setLayout(null);

		pGuest = new GuestManagementPanel();
		pGuest.setBounds(0, 0, 460, 240);
		add(pGuest);

		pBtns = new JPanel();
		pBtns.setBounds(0, 240, 460, 35);
		add(pBtns);
		pBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("고객추가 ");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAdd(e);

			}

		});
		pBtns.add(btnAdd);

		btnCancel = new JButton("취      소");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancel();

			}
		});
		pBtns.add(btnCancel);

		pTable = new JPanel();
		pTable.setBounds(0, 275, 460, 413);
		add(pTable);
		pTable.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane = new JScrollPane();
		pTable.add(scrollPane);

		table = new GuestManagementTable();
		scrollPane.setViewportView(table);
		table.setGuestList(guestList);
		table.setComponentPopupMenu(createPopupMenu());
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Guest selectedGuest = getselectedGuest();
					pGuest.setGuest(selectedGuest);

				}
			}

		});
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////

	private Guest getselectedGuest() {
		int selectedRow = table.getSelectedRow();
		return guestList.get(selectedRow);
	}

	public void clearTf() {
		pGuest.clearTf();
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Guest addGuest = pGuest.getGuest();
		guestList.add(addGuest);
		table.addRow(addGuest);
		JOptionPane.showMessageDialog(null,
				String.format("%s(%d)회원님이 추가되었습니다.", addGuest.getGuestName(), addGuest.getGuestCode()));
		pGuest.clearTf();
		System.out.println(guestList);
	}

	protected void actionPerformedBtnCancel() {
		pGuest.clearTf();
		//수정일때 취소 누르면 다시 추가로
		if(btnAdd.getActionCommand().equals("수정")) {
			btnAdd.setText("추가");
		}
	}
	
	
// 팝메뉴 ///////////////////////////////////////////////////////////////////////////////////////////
	
	public JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		 
		JMenuItem popUpdateGuest = new JMenuItem("회원정보 수정");
		JMenuItem popDeleteGuest = new JMenuItem("회원 삭제");
		
		popMenu.add(popUpdateGuest);
		popMenu.add(popDeleteGuest);
		
		popUpdateGuest.addActionListener(actionPopMenu);
		popDeleteGuest.addActionListener(actionPopMenu);
		
		return popMenu;

	}
	
	ActionListener actionPopMenu = new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("회원정보 수정")) {
				popActionUpdateGuest();
			}
			if(e.getActionCommand().equals("회원 삭제")) {
				popActionDeleteGuest();
			}
			
		}
	};
	
	public void popActionUpdateGuest() {
		int selectedIdx = table.getSelectedRow();
		if(selectedIdx == -1) {
			JOptionPane.showMessageDialog(null, "회원이 선택되지 않았습니다");
			return;
		}
		
		Guest guest = getselectedGuest();
		pGuest.setGuest(guest);
		btnAdd.setText("수정");
		
		
	}

	public void popActionDeleteGuest() { //예 아니오 취소
		int selectedIdx = table.getSelectedRow();
		
		if(selectedIdx == -1) {
			JOptionPane.showMessageDialog(null, "회원이 선택되지 않았습니다");
			return;
		}
	
		Guest selectedguest = getselectedGuest();
		int result = JOptionPane.showConfirmDialog(null, String.format("%s님을 삭제하시겠습니까?", selectedguest.getGuestName()), "confirm",JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION ) {
			Guest guest = guestList.remove(selectedIdx);
			table.deleteRow(selectedIdx);
		}else {
			return;
		}
			
		pGuest.clearTf();
		
		
	}
	
}
