/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author brybarczyk
 */
public class Ekg extends Badanie{
    private int rytm;
    private int war1;
    private BigDecimal war2;

    public Ekg() {
    }

    public Ekg(int id, Date dataBadania, String wynikOpisowy, Pobyt pb, Lekarz lekarz, int rytm, int war1, BigDecimal war2) {
        super(id, dataBadania, wynikOpisowy, pb, lekarz);
        this.rytm = rytm;
        this.war1 = war1;
        this.war2 = war2;
    }

    public int getRytm() {
        return rytm;
    }

    public void setRytm(int rytm) {
        this.rytm = rytm;
    }

    public int getWar1() {
        return war1;
    }

    public void setWar1(int war1) {
        this.war1 = war1;
    }

    public BigDecimal getWar2() {
        return war2;
    }

    public void setWar2(BigDecimal war2) {
        this.war2 = war2;
    }
    
}
