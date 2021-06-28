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
public class Pobyt {

    private int id;
    private Date dataOd;
    private Date dataDo;
    private Pacjent pacjent;
    private JednostkaOrganizacyjna jo;
    private Lekarz lekarz;

    public Pobyt(int id) {
        this.id = id;
    }

    public Pobyt(int id, Date dataOd, Date dataDo, Pacjent pacjent, JednostkaOrganizacyjna jo) {
        this.id = id;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.pacjent = pacjent;
        this.jo = jo;
    }

    public Pobyt(int id, Date dataOd, Date dataDo, Pacjent pacjent, JednostkaOrganizacyjna jo, Lekarz lekarz) {
        this.id = id;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.pacjent = pacjent;
        this.jo = jo;
        this.lekarz = lekarz;
    }

    public Pobyt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public JednostkaOrganizacyjna getJo() {
        return jo;
    }

    public void setJo(JednostkaOrganizacyjna jo) {
        this.jo = jo;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    @Override
    public String toString() {
        return "Pobyt{\n" + "\nid=\t" + id + ", \ndataOd=\t" + dataOd + ", \ndataDo=\t" + dataDo + ", \npacjent=\t" + pacjent + ", \n\njo=\t" + jo + ", \nlekarz=\t" + lekarz + '}';
    }

}
