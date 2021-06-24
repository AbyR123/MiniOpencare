/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widok;

import dane.Pobyt;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brybarczyk
 */
public class ModelTabeliPobyt extends AbstractTableModel {

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
                return Date.class;
            case 4:
                return Date.class;
            case 5:
                return String.class;
            case 6:
                return Integer.class;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Imię";
            case 1:
                return "Nazwisko";
            case 2:
                return "Pesel";
            case 3:
                return "Data_przyjecia";
            case 4:
                return "Data_wypisu";
            case 5:
                return "Oddział";
            case 6:
                return "Oddzial_id";
            default:
                return null;
        }
    }

    private ArrayList<Pobyt> listaPobytow;

    public ModelTabeliPobyt(ArrayList<Pobyt> listaPobytow) {
        this.listaPobytow = listaPobytow;
    }

    @Override
    public int getRowCount() {
        return listaPobytow.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pobyt pobyt = listaPobytow.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return pobyt.getPacjent().getImie();
            case 1:
                return pobyt.getPacjent().getNazwisko();
            case 2:
                return pobyt.getPacjent().getPesel();
            case 3:
                return pobyt.getDataOd();
            case 4:
                return pobyt.getDataDo();
            case 5:
                return pobyt.getJo().getNazwa();
            case 6:
                return pobyt.getJo().getId();
            default:
                return null;
        }
    }

    public Pobyt pobierzPobyt(int rowIndex) {
        return listaPobytow.get(rowIndex);
    }
}
