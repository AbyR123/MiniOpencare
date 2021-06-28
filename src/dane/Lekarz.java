/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane;

/**
 *
 * @author brybarczyk
 */
public class Lekarz {

    private int id;
    private String imie;
    private String nazwisko;
    private String stanowisko;

    public static int sekwencja = 1;

    public Lekarz() {
        id = sekwencja;
        sekwencja += 20;
    }

    public Lekarz(int id) {
        this.id = id;
    }

    public Lekarz(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Lekarz(int id, String imie, String nazwisko, String stanowisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
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

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return "Lekarz{\n" + "\nid=\t" + id + ", \nImie=\t" + imie + ", \nNazwisko=\t" + nazwisko + '}';
    }

}
