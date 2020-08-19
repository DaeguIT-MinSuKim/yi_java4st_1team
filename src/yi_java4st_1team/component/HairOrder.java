package yi_java4st_1team.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class HairOrder extends JPanel {
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public HairOrder() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(133, 123, 178, 146);
		add(panel);
		
		lblNewLabel = new JLabel("헤어주문");
		panel.add(lblNewLabel);
	}

}
