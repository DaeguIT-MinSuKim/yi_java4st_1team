package hairrang.table;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


@SuppressWarnings({ "serial", "hiding" })
public abstract class AbstractItemTable<Guest> extends JTable {
    private CustomModel model;
    
    public AbstractItemTable() {
        initComponents();
    }
    
    private void initComponents() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    void loadData(ArrayList<Guest> itemList) {
        model = new CustomModel(getRows(itemList), getColName() );
        setModel(model);
    }

    abstract Object[] getColName();

    Object[][] getRows(ArrayList<Guest> itemList) {
        Object[][] rows = new Object[itemList.size()][];
        for(int i=0; i<rows.length; i++) {
            rows[i] = toArray(itemList.get(i));
        }
        return rows;
    }

    abstract Object[] toArray(Guest itemList);

    public void setItems(ArrayList<Guest> itemList) {
        loadData(itemList);
        
        setWidthAndAlign();
    }

    /**
     * //column width<br>
        tableSetWidth(150, 200, 100, 100, 100, 100, 100); <br>
        //column alignment<br>
        tableCellAign(SwingConstants.CENTER, 0, 1);<br>
        tableCellAign(SwingConstants.RIGHT, 2, 3, 4, 5, 6);<br>
     */
    abstract void setWidthAndAlign();
    
    void tableCellAlign(int align, int...idx) {
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(align);
        
        TableColumnModel tcm = getColumnModel();
        for(int i=0; i<idx.length; i++) {
            tcm.getColumn(idx[i]).setCellRenderer(dtcr);
        }
    }
    
    void tableSetWidth(int...width) {
        TableColumnModel tcm = getColumnModel();
        for(int i=0; i<width.length; i++) {
            tcm.getColumn(i).setPreferredWidth(width[i]);
        }
    }
    
    private class CustomModel extends DefaultTableModel{

        public CustomModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;//각 셀 수정 불가능하게
        }
    }

    public void addRow(Guest item) {
        model.addRow(toArray(item));
        
    }

    public void removeRow(int idx) {
        model.removeRow(idx);
    }

    public void updateRow(int idx, Guest updateItem) {
        model.removeRow(idx);
        model.insertRow(idx, toArray(updateItem));
    }


}




