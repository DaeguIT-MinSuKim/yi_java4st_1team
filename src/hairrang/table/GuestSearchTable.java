package hairrang.table;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import hairrang.component.GuestSearchPanel;
import hairrang.dto.Guest;

public class GuestSearchTable extends JTable{
	private ArrayList<Guest> guestList;
	private DefaultTableModel model;
	private GuestSearchPanel GuestSearchPanel;
	

	public GuestSearchTable() {
		
		initComponents();
	}

	private void initComponents() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public void setGuestList(ArrayList<Guest> guestList) {
		
		model = new DefaultTableModel(getRows(guestList), getColNames()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//테이블 수정불가능 
		setModel(model);


		//테이블셀 중간정렬
		TableColumnModel tcm = getColumnModel();
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		tcm.getColumn(5).setCellRenderer(dtcr);
		//길이조절
		tableSetWidth(50, 80, 80, 80, 50, 120);

	}

	private void tableSetWidth(int... width) {
		TableColumnModel cModel = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public Object[] getColNames() {
		return new String[] { "고객번호", "고객명", "생년월일", "가입일자", "성별", "전화번호" };
	}

	private Object[][] getRows(ArrayList<Guest> guestList) {
		Object[][] rows = new Object[guestList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(guestList.get(i));
		}
		return rows;
	
	}
	
	private Object[] toArray(Guest guest) {
		return new Object[] { guest.getGuestCode(), guest.getGuestName(), guest.getGuestBirthday(),
				guest.getGuestJoinday(), guest.getGuestGender()==true?"여":"남", guest.getGuestPhone() };
	}

	public void action(ActionEvent e) {
		System.out.println("되나");
		
	}



//검색//////////////////////////////////////////////////////////////////////////////////

	

}
