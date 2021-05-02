/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane.zrodla_danych;

import dane.Pacjent;
import java.util.ArrayList;

/**
 *
 */
public class PacjentZrodlo {
        public ArrayList<Pacjent> pobierzListePacjentow() {
            
        ArrayList<Pacjent> lista = new ArrayList();

        Pacjent p1 = new Pacjent();
        p1.setId(10);
        p1.setImie("Imie1");
        p1.setNazwisko("Nazwisko1");
        p1.setPesel("990201234321");

        Pacjent p2 = new Pacjent();
        p2.setId(100);
        p2.setImie("Imie2");
        p2.setNazwisko("Nazwisko2");
        p2.setPesel("980201234323");

        Pacjent p3 = new Pacjent();
        p3.setId(20);
        p3.setImie("Imie3");
        p3.setNazwisko("Nazwisko3");
        p3.setPesel("970201234321");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        return lista;
    }
}
