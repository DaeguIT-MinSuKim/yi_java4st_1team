package yi_java4st_1team.table;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import yi_java4st_1team.dto.Sales;

public class hairOrder extends JTable {
	private ArrayList<Sales> items;
	private CustomModel model;
	public hairOrder() {
		initComponents();
	}
	public hairOrder(ArrayList<Sales> items) {
		setItems(items);
		initComponents();
	}
	private void initComponents() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void setItems(ArrayList<Sales> items) {
		this.items  = items;
		loadData();
		
	}
	private void loadData() {
		model = new CustomModel(loadRows(), columnNames());
		setModel(model);
	}
	private Object[][] loadRows() {
		Object[][] rows = new Object[items.size()][];
		for(int i=0; i<items.size(); i++) {
			rows[i] = toArray(items.get(i));
		}
		return rows;
	}
	private Object[] toArray(Sales item) {
		return new Object[] {item.getSalesCode(),item.getSalesDay(),item.getGuestName(),item.getHairName(),item.getEventName(),item.getPirce()};
	}
	private String[] columnNames() {
		return new String[] {
			"영업번호", "영업일자", "헤어명", "단가", "이벤트명", "금액"
		};
	}
	public void addRow(Sales item) {
		model.addRow(toArray(item));
	}
	
	public void removeRow() {
		model.removeRow(getSelectedRow());
	}
	
	public void reset(int i) {
		System.out.println("삭제");
		/*for(int i = items.size() - 1; i >= 0; i--) {
			System.out.println("i = " + i);
			System.out.println("items.size() = " + items.size());
			System.out.println(items.get(i));
			model.removeRow(0);
		}*/
		model.removeRow(i);
		
		
		
	}
	
	public void updateRow(Sales item) {
		int row = items.indexOf(item);
		model.removeRow(row);
		model.insertRow(row, toArray(item));
		clearSelection();
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
