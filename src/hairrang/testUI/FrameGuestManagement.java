package hairrang.testUI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import hairrang.dto.Guest;
import hairrang.service.GuestService;

public class FrameGuestManagement extends JFrame implements ActionListener {

	private GuestService gService;
	private JPanel contentPane;
	private ArrayList<Guest> guestList;
	private GuestManagementTable table;
	private GuestManagementPanel pGuest;
	private JPanel pBtn;
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel pTable;
	private JScrollPane scrollPane;
	private int curr;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGuestManagement frame = new FrameGuestManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameGuestManagement() {
		
		gService = new GuestService();
		guestList = (ArrayList<Guest>) gService.getGuestList();
		curr = gService.getGuestCurrVal();
		System.out.println("curr: " + curr);
//		
//		Calendar c = Calendar.getInstance();
//		c.set(1991, 12, 19);
//		Date birth = new Date(c.getTimeInMillis());
		Date join = new Date();
		new SimpleDateFormat("yyyy-MM-dd").format(join);
		System.out.println(join);
	
//		Guest test = new Guest(56, "김혜진", birth, join, "010-5656-5656", 1, "");
//		pGuest.setGuest(test);
		
		initComponent();
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pGuest = new GuestManagementPanel();
		pGuest.setBounds(5, 5, 713, 179);
		contentPane.add(pGuest);
		pGuest.setLayout(null);
		
		
		//////////////////////////////////////////////
		pGuest.setTfJoinDay();
		pGuest.setTfNo(curr);
		
		//////////////////////////////////////////////

		
		pBtn = new JPanel();
		pBtn.setBounds(5, 184, 713, 33);
		contentPane.add(pBtn);
		pBtn.setLayout(null);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(362, 0, 97, 23);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(471, 0, 97, 23);
		pBtn.add(btnCancel);
		
		pTable = new JPanel();
		pTable.setBounds(5, 217, 713, 278);
		contentPane.add(pTable);
		pTable.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		pTable.add(scrollPane);
		
		table = new GuestManagementTable();
		scrollPane.setViewportView(table);
		
		
		table.setItems(guestList);
		table.setComponentPopupMenu(createPopMenu());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Guest selectedGuest = getSelectedGuest();
					pGuest.setGuest(selectedGuest);

				}
			}
		});
				
	}

//버튼////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		
		if(e.getSource() == btnAdd) {
			if(e.getActionCommand().contentEquals("추가")) {
				
				try {
					btnAddActionPerformed(e);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getActionCommand().equals("수정"))
				try {
					btnUpdateActionPerformed();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		}
		
		
	}

	//고객리턴
	private Guest getSelectedGuest() {
		int selectedRow = table.getSelectedRow();
		return guestList.get(selectedRow);
	}

	
	//추가
	private void btnAddActionPerformed(ActionEvent e) throws ParseException {
		Guest addGuest;
		try {
			addGuest = pGuest.getGuest();
			//System.out.println(addGuest);
			gService.addGuest(addGuest);
			table.addRow(addGuest);

			curr++;
			
			
			JOptionPane.showMessageDialog(null, String.format("%s님이 추가되었습니다.",addGuest.getGuestName()));
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		pGuest.clearTf();
		pGuest.setTfNo(curr);
		
	}

	//수정
	private void btnUpdateActionPerformed() throws ParseException {
		Guest updateGuest = getSelectedGuest();
		Guest updateInfo = pGuest.getGuest();
		
		int idx = guestList.indexOf(updateGuest);
		table.updateRow(idx, updateInfo);
		gService.updateGuest(updateInfo);
		
		pGuest.clearTf();
		btnAdd.setText("추가");
		
//		System.out.println(updateGuest);
//		System.out.println(updateInfo);
		
	}
	
	//제거
	private void btnCancelActionPerformed(ActionEvent e) {
		pGuest.clearTf();
	}
	
	
//팝메뉴///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JPopupMenu createPopMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateMenu = new JMenuItem("고객정보수정");
		JMenuItem deleteMenu = new JMenuItem("고객정보삭제");
		
		popMenu.add(updateMenu);
		popMenu.add(deleteMenu);
		
		updateMenu.addActionListener(addActionlistener);
		deleteMenu.addActionListener(addActionlistener);
		
		return popMenu;
	}
	
	ActionListener addActionlistener = new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("고객정보수정")) {
				try {
					actionUpdate();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getActionCommand().equals("고객정보삭제")) {
				actionDelete();
			}
				
			
		}
	};

	//팝업메뉴를 눌렀을때
	protected void actionUpdate() throws ParseException {
		JOptionPane.showMessageDialog(null, "정보 수정 후 수정버튼을 눌러주세요.");
		Guest update = getSelectedGuest();
		pGuest.setGuest(update);
		btnAdd.setText("수정");
		
	}

	protected void actionDelete() {
		int idx = table.getSelectedRow();
		Guest delete = getSelectedGuest();
		
		int result = JOptionPane.showConfirmDialog(null, String.format("%s님을 삭제하시겠습니까?", delete.getGuestName()), "삭제", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			gService.deleteGuest(delete);
			table.removeRow(idx);
			pGuest.clearTf();
		}else {
			return;
		}
		
	}



	
	
}
