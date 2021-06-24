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
public class Pacjent {

    private int id;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String plec;
    private Date dataUrodzenia;
    private String miejsceUrodzenia;
    private Date dataZgonu;

    private static int sekwencja = 10;

    public Pacjent() {
        id = sekwencja;
        sekwencja++;
    }

    public Pacjent(int id, String imie, String nazwisko, String pesel) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public Pacjent(int id, String imie, String nazwisko, String pesel, String plec, Date dataUrodzenia, String miejsceUrodzenia, Date dataZgonu) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.plec = plec;
        this.dataUrodzenia = dataUrodzenia;
        this.miejsceUrodzenia = miejsceUrodzenia;
        this.dataZgonu = dataZgonu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getMiejsceUrodzenia() {
        return miejsceUrodzenia;
    }

    public void setMiejsceUrodzenia(String miejsceUrodzenia) {
        this.miejsceUrodzenia = miejsceUrodzenia;
    }

    public Date getDataZgonu() {
        return dataZgonu;
    }

    public void setDataZgonu(Date dataZgonu) {
        this.dataZgonu = dataZgonu;
    }
    
//    @Override
//    public String toString() {
//        return "Pacjent{\n" + "\nid=\t" + id + ", \nimie=\t" + imie + ", \nnazwisko=\t" + nazwisko + ", \npesel=\t" + pesel +'}';
//    }
    

    @Override
    public String toString() {
        return "Pacjent{\n" + "\nid=\t" + id + ", \nimie=\t" + imie + ", \nnazwisko=\t" + nazwisko + ", \npesel=\t" + pesel + ", \nplec=\t" + plec + ", \ndataUr=\t" + dataUrodzenia + ", \nmiejsceUr=\t" + miejsceUrodzenia + ", \ndataZgonu=\t" + dataZgonu + '}';
    }
    

}
