/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane.zrodlaDanych;

import dane.JednostkaOrganizacyjna;
import dane.Lekarz;
import dane.Pacjent;
import dane.Pobyt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author brybarczyk
 */
public class PobytZrodlo {

    private BazaDanych bd;

    public PobytZrodlo() {
        bd = new BazaDanych();
    }

    PacjentZrodlo pcZrodlo = new PacjentZrodlo();
    JednostkaOrganizacyjnaZrodlo joZrodlo = new JednostkaOrganizacyjnaZrodlo();

    public ArrayList<Pobyt> pobierzListePobytow(String text, JednostkaOrganizacyjna jo) throws SQLException {

        ArrayList<Pacjent> listaPc = pcZrodlo.pobierzListePacjentow();
        ArrayList<JednostkaOrganizacyjna> listaJO = joZrodlo.pobierzJednostki();

        Pobyt pobyt1 = new Pobyt();
        pobyt1.setId(1);
        pobyt1.setPacjent(listaPc.get(1));
        pobyt1.setDataOd(new Date());
        pobyt1.setDataDo(new Date());
        pobyt1.setJo(listaJO.get(1));

        Pobyt pobyt2 = new Pobyt();
        pobyt2.setId(1);
        pobyt2.setPacjent(listaPc.get(2));
        pobyt2.setDataOd(new Date());
        pobyt2.setDataDo(new Date());
        pobyt2.setJo(listaJO.get(2));

        Pobyt pobyt3 = new Pobyt();
        pobyt3.setId(1);
        pobyt3.setPacjent(listaPc.get(2));
        pobyt3.setDataOd(new Date());
        pobyt3.setDataDo(new Date());
        pobyt3.setJo(listaJO.get(3));

        Pobyt pobyt4 = new Pobyt();
        pobyt4.setId(1);
        pobyt4.setPacjent(listaPc.get(1));
        pobyt4.setDataOd(new Date());
        pobyt4.setDataDo(new Date());
        pobyt4.setJo(listaJO.get(2));

        Pobyt pobyt5 = new Pobyt();
        pobyt5.setId(1);
        pobyt5.setPacjent(listaPc.get(2));
        pobyt5.setDataOd(new Date());
        pobyt5.setDataDo(new Date());
        pobyt5.setJo(listaJO.get(3));

        ArrayList<Pobyt> lista = new ArrayList();

        lista.add(pobyt1);
        lista.add(pobyt2);
        lista.add(pobyt3);
        lista.add(pobyt4);
        lista.add(pobyt5);

        return lista;
    }

    public ArrayList<Pobyt> pobierzListePobytowBD(int weJoId, String filtr) throws SQLException {
        ArrayList<Pobyt> pb = new ArrayList<Pobyt>();

//           -------- wersja podatna na SQL Injection ----------
//            String query = "select * from pobyty_pobierz_liste("+weJoId+" , '"+filtr+"')";
//
//            ------- zabezpieczenie przed SQL Injection -------
        String sql = "select * from pobyty_pobierz_liste(? , ?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, weJoId);
        mapaParam.put(2, filtr);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);

        while (rs.next()) {
            // nazwy kolumn takie same jak w funkcji 
            Pacjent pc = new Pacjent(rs.getInt("pacjent_id"), rs.getString("pacjent_imie"), rs.getString("pacjent_nazwisko"), rs.getString("pacjent_pesel"));
            JednostkaOrganizacyjna jo = new JednostkaOrganizacyjna(rs.getInt("jo_id"), rs.getString("jo_nazwa"));
            Pobyt pobyt = new Pobyt(rs.getInt("pobyt_id"), rs.getDate("pobyt_data_przyjecia"), rs.getDate("pobyt_data_wypisu"), pc, jo);
            pb.add(pobyt);
        }
        return pb;
    }

    public Pobyt pobierzDanePobytuBD(int wePbId) throws SQLException {

        String sql = "select * from pobyt_pobierz_dane(?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, wePbId);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        if (rs.next()) {
            Pacjent pc = new Pacjent(rs.getInt("pacjent_id"), rs.getString("pacjent_imie"), rs.getString("pacjent_nazwisko"), rs.getString("pacjent_pesel"), rs.getString("pacjent_plec"), rs.getDate("pacjent_data_Urodzenia"), rs.getString("pacjent_MiejsceUrodzenia"), rs.getDate("pacjent_data_Zgonu"));
            JednostkaOrganizacyjna jo = new JednostkaOrganizacyjna(rs.getInt("jo_id"), rs.getString("jo_nazwa"));
            Lekarz lk = new Lekarz(rs.getInt("lekarz_przyjmujacy_id"), rs.getString("lekarz_przyjmujacy_imie"), rs.getString("lekarz_przyjmujacy_nazwisko"));
            Pobyt pb = new Pobyt(rs.getInt("pobyt_id"), rs.getDate("pobyt_data_przyjecia"), rs.getDate("pobyt_data_wypisu"), pc, jo, lk);
            return pb;
        } else {
            return null;
        }
    }

    public void aktualizujDanePobytuBD(int wePbId, String wePcImie, String wePcNazwisko, int weJoId) throws SQLException {

        String sql = "select pobyt_aktualizuj_dane(?, ?, ?, ?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, wePbId);
        mapaParam.put(2, wePcImie);
        mapaParam.put(3, wePcNazwisko);
        mapaParam.put(4, weJoId);
        bd.pobierzDaneZBazyDanych(sql, mapaParam);
        System.out.println(wePbId + wePcImie + wePcNazwisko + weJoId);
    }

}