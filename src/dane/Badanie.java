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
public class Badanie{

    private int id;
    private Date dataBadania;
    private String wynikOpisowy;
    private Pobyt pb;
    private Lekarz lekarz;

    public Badanie() {
    }

    public Badanie(int id, Date dataBadania, String wynikOpisowy, Pobyt pb, Lekarz lekarz) {
        this.id = id;
        this.dataBadania = dataBadania;
        this.wynikOpisowy = wynikOpisowy;
        this.pb = pb;
        this.lekarz = lekarz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataBadania() {
        return dataBadania;
    }

    public void setDataBadania(Date dataBadania) {
        this.dataBadania = dataBadania;
    }

    public String getWynikOpisowy() {
        return wynikOpisowy;
    }

    public void setWynikOpisowy(String wynikOpisowy) {
        this.wynikOpisowy = wynikOpisowy;
    }

    public Pobyt getPb() {
        return pb;
    }

    public void setPb(Pobyt pb) {
        this.pb = pb;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }
    
    @Override
    public String toString() {
        return "id = " + id + ", dataBadania = " + dataBadania + '}';
    }
}
