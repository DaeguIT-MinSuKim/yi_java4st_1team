package yi_java4st_1team.table;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yi_java4st_1team.dto.Customer;

import javax.swing.ListSelectionModel;

public class customerTable extends JTable {
	private ArrayList<Customer> items;
	
	public customerTable() {
		initComponents();
	}
	
	public customerTable(ArrayList<Customer> items) {
		setItems(items);
		initComponents();
	}
	
	private void setItems(ArrayList<Customer> items) {
		this.items  = items;
		loadData();	
	}

	private void loadData() {
		CustomModel model = new CustomModel(loadRows(), columnNames());
		setModel(model);
	}

	private void initComponents() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private Object[][] loadRows() {
		Object[][] rows = new Object[items.size()][];
		for(int i=0; i<items.size(); i++) {
			rows[i] = toArray(items.get(i));
		}
		return rows;
	}
	
	private Object[] toArray(Customer item) {
		return new Object[] {item.getCustomercode(),item.getCustomername(),item.getCustomerjoin(),item.getCustomeryear()};
	}
	
	private String[] columnNames() {
		return new String[] {
			"고객 번호", "고객명", "생년 월일", "가입 일자"
		};
	}
	
	private class CustomModel extends DefaultTableModel{

		public CustomModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
}
