package yi_java4st_1team.table;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yi_java4st_1team.dto.Customer;
import yi_java4st_1team.dto.Hairgoods;

import javax.swing.ListSelectionModel;

public class hairTable extends JTable {
	private ArrayList<Hairgoods> items;
	public hairTable() {
		initComponents();
	}
	public hairTable(ArrayList<Hairgoods> items) {
		setItems(items);
		initComponents();
	}
	private void initComponents() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	private void setItems(ArrayList<Hairgoods> items) {
		this.items  = items;
		loadData();
		
	}
	private void loadData() {
		CustomModel model = new CustomModel(loadRows(), columnNames());
		setModel(model);
	}
	private Object[][] loadRows() {
		Object[][] rows = new Object[items.size()][];
		for(int i=0; i<items.size(); i++) {
			rows[i] = toArray(items.get(i));
		}
		return rows;
	}
	private Object[] toArray(Hairgoods item) {
		return new Object[] {item.getHairCode(),item.getHairName(),item.getHairPrice()};
	}
	private String[] columnNames() {
		return new String[] {
			"헤어 번호", "헤어명", "단 가"
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
