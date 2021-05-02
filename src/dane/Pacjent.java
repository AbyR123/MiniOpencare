/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;


/**
 *
 */
public class Pacjent {

    private int id;
    private String imie;
    private String nazwisko;
    private String pesel;

    private static int sekwencja = 10;

    public Pacjent() {
        id = sekwencja;
        sekwencja++;
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

    @Override
    public String toString() {
        return "Pacjent{\n" + "\nid=\t" + id + ", \nimie=\t" + imie + ", \nnazwisko=\t" + nazwisko + ", \npesel=\t" + pesel + '}';
    }

}
