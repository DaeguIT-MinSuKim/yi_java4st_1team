package yi_java4st_1team.table;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ReportTable extends JTable {
	public ReportTable() {
		initComponents();
	}
	private void initComponents() {
		setModel(new DefaultTableModel(
			new Object[][] {
				{"01", "2015-05-15", "고연정", "커트", "일반", "15,000"},
				{"02", "2015-05-16", "김연지", "커트", "일반", "15,000"},
			},
			new String[] {
					"영업번호","영업일자","고객명","헤어명","이벤트명","금액"
			}
			
		));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

}
