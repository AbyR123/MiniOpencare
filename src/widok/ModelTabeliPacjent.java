package widok;

import dane.Pacjent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brybarczyk
 */
public class ModelTabeliPacjent extends AbstractTableModel {

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;   //  new Integer(1).getClass();
            case 1:
                return String.class;    // new String().getClass();
            case 2:
                return String.class;    //new String().getClass();
            case 3:
                return String.class;     //new String().getClass();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Index";
            case 1:
                return "Imie";
            case 2:
                return "Nazwisko";
            case 3:
                return "Pesel";
            default:
                return null;
        }
    }

    private ArrayList<Pacjent> listaPacjentow;

    public ModelTabeliPacjent(ArrayList<Pacjent> listaPacjentow) {
        this.listaPacjentow = listaPacjentow;
    }

    @Override
    public int getRowCount() {
        return listaPacjentow.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacjent p = listaPacjentow.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getImie();
            case 2:
                return p.getNazwisko();
            case 3:
                return p.getPesel();
            default:
                return null;
        }
    }

    public Pacjent pobierzPacjenta(int rowIndex) {
        return listaPacjentow.get(rowIndex);
    }
}