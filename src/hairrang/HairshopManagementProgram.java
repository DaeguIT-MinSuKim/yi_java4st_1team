package hairrang;

import java.awt.BorderLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HairshopManagementProgram extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel layeredPane;
	private JPanel panel_1;
	
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	private JPanel emptyPane;
	
	private JPanel menuPanel;
	
	private Dimension btnMenuDim = new Dimension(100, 60);
	private Dimension btnHomeDim = new Dimension(230, 90);
	
	private JPanel menuBtnsPanel;
	private JButton btnMenu1;
	private JButton btnMenu2;
	private JButton btnMenu3;
	private JButton btnMenu4;
	private JButton btnMenu5;
	private JButton btnHome;
	private JButton[] btnsMenu;

	private Color mainColor = new Color(153, 102, 255);
	private JPanel[] pArr;
	private JLabel lblMenuName;
	private JPanel sidePanel;

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
		setBounds(100, 50, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		setTitle
		

		/* panel 정의 */

		layeredPane = new JPanel();
		layeredPane.setBounds(30, 160, 700, 540);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		
		// dto 수정하면서 각 패널들 고장나서 기본 JPanel로 바꿔 넣음
		// dto에 맞게 구현하고 나면 morph 하세요.
		
		p1 = new JPanel();
		layeredPane.add(p1, "name_190917990402500");
		p1.setLayout(null);

		p2 = new JPanel();
		layeredPane.add(p2, "name_191035038994000");
		p2.setLayout(null);

		p3 = new JPanel();
		layeredPane.add(p3, "name_191036958001300");
		p3.setLayout(new GridLayout(1, 0, 0, 0));
		
		p4 = new JPanel();
		layeredPane.add(p4, "name_779538988255300");
		p4.setLayout(new BorderLayout(0, 0));
		
		p5 = new JPanel();
		layeredPane.add(p5, "name_779540758050400");
		
		pArr = new JPanel[] { p1, p2, p3, p4, p5};
		
		/* 메뉴부 */
		
		String fontPath = System.getProperty("user.dir") + File.separator + "fonts" + File.separator;
		InputStream is = HairshopManagementProgram.class.getResourceAsStream(fontPath + "GmarketSansTTFBold.ttf");
		File gfont_file = new File(fontPath + "GmarketSansTTFBold.ttf");
		Font gSansBold = Font.createFont(Font.TRUETYPE_FONT, gfont_file);
		Font gSansBold28 = gSansBold.deriveFont(28f);
		Font gSansBold20 = gSansBold.deriveFont(20f);
		Font gSansBold16 = gSansBold.deriveFont(16f);

		
		menuPanel = new JPanel();
		menuPanel.setBackground(mainColor);
		menuPanel.setBounds(0, 0, 1008, 90);
		contentPane.add(menuPanel);
		menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));



		btnHome = new JButton("HAIRRANG");
		btnHome.setFont(gSansBold28);
		btnHome.setPreferredSize(new Dimension(230, 90));
		btnHome.addActionListener(this);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setForeground(Color.white);
		menuPanel.add(btnHome);

		emptyPane = new JPanel();
		emptyPane.setPreferredSize(new Dimension(20, 90));
		emptyPane.setOpaque(false);
		menuPanel.add(emptyPane);
		
		menuBtnsPanel = new JPanel();
		menuBtnsPanel.setOpaque(false);
		menuPanel.add(menuBtnsPanel);
		menuBtnsPanel.setLayout(new GridLayout(1, 6, 0, 0));
		menuBtnsPanel.setPreferredSize(new Dimension(700, 90));

		btnMenu1 = new JButton("고객 관리");
		btnMenu2 = new JButton("고객 검색");
		btnMenu3 = new JButton("주문");
		btnMenu4 = new JButton("주문 내역");
		btnMenu5 = new JButton("통계");

		
		btnsMenu = new JButton[] { btnMenu1, btnMenu2, btnMenu3, btnMenu4, btnMenu5};

		for (int i = 0; i < btnsMenu.length; i++) {
			btnsMenu[i].addActionListener(this);
			btnsMenu[i].setPreferredSize(btnMenuDim);
			btnsMenu[i].setOpaque(false);
			btnsMenu[i].setContentAreaFilled(false);
			btnsMenu[i].setBorderPainted(false);
			btnsMenu[i].setFont(gSansBold16);
			btnsMenu[i].setForeground(Color.white);
		}
		
		menuBtnsPanel.add(btnMenu1);
		menuBtnsPanel.add(btnMenu2);
		menuBtnsPanel.add(btnMenu3);
		menuBtnsPanel.add(btnMenu4);
		menuBtnsPanel.add(btnMenu5);

		
		lblMenuName = new JLabel("▶ 고객 검색");
		lblMenuName.setBounds(30, 120, 140, 32);
		lblMenuName.setFont(gSansBold20);
		contentPane.add(lblMenuName);
		
		sidePanel = new JPanel();
		sidePanel.setBounds(750, 90, 258, 639);
		contentPane.add(sidePanel);
	}

	public void actionPerformed(ActionEvent e) {
		/*
		if (e.getSource() == btnMenu6) {
			JFrame temp = new JFrame();.
			temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			temp.setBounds(100, 100, 940, 690);
			temp.getContentPane().add(new chartPanel());
			temp.setVisible(true);
			return;
		}
		*/
		
//		if (e.getSource() == btnMenu6 ) {
//			p6.add(new chartPanel());
//			p6.setVisible(true);
//			return;
//		}
		
		if (e.getSource() == btnMenu1 || e.getSource() == btnMenu2 || e.getSource() == btnMenu3 || e.getSource() == btnMenu4 || e.getSource() == btnMenu5 ) {
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