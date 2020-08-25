package hairrang.testUI;


import java.text.SimpleDateFormat;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import hairrang.dto.Guest;

public class GuestManagementTable extends AbstractItemTable<Guest> {
	public GuestManagementTable() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	@Override
	Object[] getColName() {
		return new String[] {"고객번호","고객명", "생년월일", "가입일자", "전화번호", "성별", "메모"};
	}
	//new SimpleDateFormat("yyyy-MM-dd").format(guest.getBirthday())
	@Override
	Object[] toArray(Guest itemList) {
		return new Object[] {
				itemList.getGuestNo(), 
				itemList.getGuestName(), 
				new SimpleDateFormat("yyyy-MM-dd").format(itemList.getBirthday()), 
				new SimpleDateFormat("yyyy-MM-dd").format(itemList.getJoinDay()), 
				itemList.getPhone(), 
				itemList.getGender()==1?"여":"남", 
				itemList.getGuestNote()
			
		};
	}

	@Override
	void setWidthAndAlign() {
		
		TableColumnModel tcm = getColumnModel();
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		tcm.getColumn(5).setCellRenderer(dtcr);
		tcm.getColumn(6).setCellRenderer(dtcr);
		
		tableSetWidth(60,80,100,100,100,40,150);
	}
	
	

}
