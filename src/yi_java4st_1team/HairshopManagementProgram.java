package yi_java4st_1team;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import yi_java4st_1team.component.GuestManagement;
import yi_java4st_1team.component.GuestSearch;
import yi_java4st_1team.component.ReportPanel;
import yi_java4st_1team.component.chartPanel;
import yi_java4st_1team.table.hairOrderSearch;
import yi_java4st_1team.table.hairmanagement;

import java.awt.BorderLayout;

public class HairshopManagementProgram extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel layeredPane;
	private JPanel panel_1;
	private hairmanagement p3;
	private GuestSearch p2;
	private GuestManagement p1;
	private JPanel menuPanel;
	
	private Dimension btnMenuDim = new Dimension(120, 60);
	private Dimension btnHomeDim = new Dimension(230, 100);
	
	private JPanel menuBtnsPanel;
	private JButton btnMenu1;
	private JButton btnMenu2;
	private JButton btnMenu3;
	private JButton btnMenu4;
	private JButton btnMenu5;
	private JButton btnMenu6;
	private JButton btnHome;
	private JButton[] btnsMenu;

	private Color mainColor = new Color(153, 102, 255);
	private hairOrderSearch p4;
	private ReportPanel p5;
	private JPanel p6;
	private JPanel emptyPane;
	private JPanel[] pArr;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	public HairshopManagementProgram() throws FontFormatException, IOException {

		initComponents();
	}

	private void initComponents() throws FontFormatException, IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1280, 960);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		setTitle
		

		/* panel 정의 */

		layeredPane = new JPanel();
		//      panel.setBounds(30, 200, 460, 690);
		layeredPane.setBounds(30, 200, 970, 690);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		p1 = new GuestManagement();
		layeredPane.add(p1, "name_190917990402500");
		p1.setLayout(null);

		p2 = new GuestSearch();
		layeredPane.add(p2, "name_191035038994000");
		p2.setLayout(null);

		p3 = new hairmanagement();
		layeredPane.add(p3, "name_191036958001300");
		p3.setLayout(new GridLayout(1, 0, 0, 0));
		
		p4 = new hairOrderSearch();
		layeredPane.add(p4, "name_779538988255300");
		p4.setLayout(new BorderLayout(0, 0));
		
		p5 = new ReportPanel();
		layeredPane.add(p5, "name_779540758050400");
		
//		p6 = new chartPanel();
		p6 = new JPanel();
		layeredPane.add(p6, "name_779542901747700");
		p6.setLayout(new GridLayout(1, 0, 0, 0));

		pArr = new JPanel[] {	p1, p2, p3, p4, p5, p6 };
		
		/* 메뉴부 */
		
		String fontPath = System.getProperty("user.dir") + File.separator + "fonts" + File.separator;
		InputStream is = HairshopManagementProgram.class.getResourceAsStream(fontPath + "GmarketSansTTFBold.ttf");
		File gfont_file = new File(fontPath + "GmarketSansTTFBold.ttf");
		Font gSansBold = Font.createFont(Font.TRUETYPE_FONT, gfont_file);
		Font gSansBold28 = gSansBold.deriveFont(28f);
		Font gSansBold20 = gSansBold.deriveFont(16f);

		
		menuPanel = new JPanel();
		menuPanel.setBackground(mainColor);
		menuPanel.setBounds(0, 0, 1264, 100);
		contentPane.add(menuPanel);
		menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));



		btnHome = new JButton("HAIRRANG");
		btnHome.setFont(gSansBold28);
		btnHome.setPreferredSize(new Dimension(230, 100));
		btnHome.addActionListener(this);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setForeground(Color.white);
		menuPanel.add(btnHome);

		
		emptyPane = new JPanel();
		emptyPane.setPreferredSize(new Dimension(40, 100));
		emptyPane.setOpaque(false);
		menuPanel.add(emptyPane);
		
		
		
		menuBtnsPanel = new JPanel();
		menuBtnsPanel.setOpaque(false);
		menuPanel.add(menuBtnsPanel);
		menuBtnsPanel.setLayout(new GridLayout(1, 6, 0, 0));
		menuBtnsPanel.setPreferredSize(new Dimension(700, 100));

		btnMenu1 = new JButton("고객 관리");
		btnMenu2 = new JButton("고객 검색");
		btnMenu3 = new JButton("주문");
		btnMenu4 = new JButton("주문 내역");
		btnMenu5 = new JButton("보고서");
		btnMenu6 = new JButton("차트");

		
		btnsMenu = new JButton[] { btnMenu1, btnMenu2, btnMenu3, btnMenu4, btnMenu5, btnMenu6 };

		for (int i = 0; i < btnsMenu.length; i++) {
			btnsMenu[i].addActionListener(this);
			btnsMenu[i].setPreferredSize(btnMenuDim);
			btnsMenu[i].setOpaque(false);
			btnsMenu[i].setContentAreaFilled(false);
			btnsMenu[i].setBorderPainted(false);
			btnsMenu[i].setFont(gSansBold20);
			btnsMenu[i].setForeground(Color.white);
		}
		
		menuBtnsPanel.add(btnMenu1);
		menuBtnsPanel.add(btnMenu2);
		menuBtnsPanel.add(btnMenu3);
		menuBtnsPanel.add(btnMenu4);
		menuBtnsPanel.add(btnMenu5);
		menuBtnsPanel.add(btnMenu6);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMenu6) {
			JFrame temp = new JFrame();
			temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			temp.setBounds(100, 100, 940, 690);
			temp.getContentPane().add(new chartPanel());
			temp.setVisible(true);
			return;
		}
		
//		if (e.getSource() == btnMenu6 ) {
//			p6.add(new chartPanel());
//			p6.setVisible(true);
//			return;
//		}
		
		if (e.getSource() == btnMenu1 || e.getSource() == btnMenu2 || e.getSource() == btnMenu3 || e.getSource() == btnMenu4 || e.getSource() == btnMenu5 ||  e.getSource() == btnMenu6) {
			btnsMenuActionPerformed(e);
		}
	}
	
	protected void btnsMenuActionPerformed(ActionEvent e) {
		for(int i = 0; i < btnsMenu.length; i++) {
			if (e.getSource() == btnsMenu[i]) {
				switchPanel(i);
			}
		}
	}

	private void switchPanel(int i) {
		layeredPane.removeAll();
		layeredPane.add(pArr[i]);
		layeredPane.getComponent(0).getComponentAt(500, 20).setVisible(false);
		repaint();
		revalidate();
	}
}