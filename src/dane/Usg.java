/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;

import java.util.Date;

/**
 *
 * @author brybarczyk
 */
public class Usg extends Badanie {
    private int nazwaId;
    private String nazwa;

    public Usg() {
    }

    public Usg(int nazwaId, String nazwa) {
        this.nazwaId = nazwaId;
        this.nazwa = nazwa;
    }

    public Usg(int id, Date dataBadania, String wynikOpisowy, Pobyt pb, Lekarz lekarz, int nazwaId, String nazwa) {
        super(id, dataBadania, wynikOpisowy, pb, lekarz);
        this.nazwaId = nazwaId;
        this.nazwa = nazwa;
    }

    public int getNazwaId() {
        return nazwaId;
    }

    public void setNazwaId(int nazwaId) {
        this.nazwaId = nazwaId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usg other = (Usg) obj;
        if (this.nazwaId != other.nazwaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
