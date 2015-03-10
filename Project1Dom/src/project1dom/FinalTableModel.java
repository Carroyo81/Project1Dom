
package project1dom;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Charlie
 */

    public class FinalTableModel extends AbstractTableModel {

    private List<CD> list = new ArrayList();
    private String[] columnNames = {"Title", "Artist", "Country", "Company", "Price", "Year"};

    public FinalTableModel(List<CD> list) {
        this.list = list;
    }

   

    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CD cd = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cd.getTitle();
            case 1:
                return cd.getArtist();
            case 2:
                return cd.getCountry();
            case 3:
                return cd.getCompany();
            case 4:
                return cd.getPrice();
            case 5:
                return cd.getYear();

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Double.class;
            case 5:
                return Integer.class;
        }
        return null;
    }

    }
