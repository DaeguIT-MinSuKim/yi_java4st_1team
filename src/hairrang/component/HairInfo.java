package hairrang.component;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class HairInfo extends JPanel implements ActionListener {
	private HairInfoPanel pGuest;
	private JPanel pBtns;
	private JPanel pTable;
	private JButton btnClose;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel pHairInfo;
	private JLayeredPane hairInfoLayered;

	
	
	public HairInfo() {
		setLayout(null);
		setBounds(0, 0, 460, 690);
		
		pGuest = new HairInfoPanel();
		pGuest.setBounds(0, 0, 460, 140);
		add(pGuest);
		pGuest.setLayout(null);
		
		pBtns = new JPanel();
		pBtns.setBounds(0, 645, 460, 35);
		add(pBtns);
		pBtns.setLayout(null);
		
		btnClose = new JButton("닫  기");
		btnClose.addActionListener(this);
		btnClose.setBounds(196, 5, 67, 25);
		pBtns.add(btnClose);
		
		pTable = new JPanel();
		pTable.setBounds(0, 140, 460, 505);
		add(pTable);
		pTable.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		pTable.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	/*
	public void switchPanels(JPanel panel) {
		   pGuest.removeAll();
		   pGuest.add(panel);
		   pGuest.repaint();
		   pGuest.revalidate();
	   }
	*/
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClose) {
			btnCloseActionPerformed(e);
		}
	}
	
	protected void btnCloseActionPerformed(ActionEvent e) {
//		System.out.println(this);
//		this.setVisible(false);
//		System.out.println(isVisible());
//		System.out.println(getParent().getComponent(0));
		getParent().setVisible(false);
		getParent().getParent().repaint();
		getParent().getParent().revalidate();
//		System.out.println(isVisible());
//		this.setVisible(false);
	}
	
}
