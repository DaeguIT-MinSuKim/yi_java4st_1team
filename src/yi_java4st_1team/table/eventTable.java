package yi_java4st_1team.table;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yi_java4st_1team.dto.Customer;
import yi_java4st_1team.dto.Event;

import javax.swing.ListSelectionModel;

public class eventTable extends JTable {
	private ArrayList<Event> items;
	
	public eventTable() {
		initComponents();
	}
	public eventTable(ArrayList<Event> items) {
		setItems(items);
		initComponents();
	}
	private void initComponents() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	private void setItems(ArrayList<Event> items) {
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
	private Object[] toArray(Event item) {
		Object Stirng;
		return new Object[] {item.getEventcode(),item.getEventname(),String.format("%.1f", item.getEventsale())};
	}
	private String[] columnNames() {
		return new String[] {
			"이벤트 번호", "이벤트명", "할인율"
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
