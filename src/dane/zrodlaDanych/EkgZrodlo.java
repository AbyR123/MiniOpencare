/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane.zrodlaDanych;

import dane.Ekg;
import dane.Lekarz;
import dane.Pobyt;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author brybarczyk
 */
public class EkgZrodlo {

    private BazaDanych bd;

    public EkgZrodlo() {
        bd = new BazaDanych();
    }

    public Ekg pobierzBadanieEkgBD(int weBId) throws SQLException {
        String sql = "select * from badanie_pobierz_ekg(?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, weBId);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        if (rs.next()) {
            Pobyt badaniePb = new Pobyt(rs.getInt("pobyt_id"));
            Lekarz badanieLk = new Lekarz(rs.getInt("lekarz_opiujacy_id"));
            Ekg badanieEkg = new Ekg(rs.getInt("badanie_id"), rs.getTimestamp("data_badania"), rs.getString("wynik_opisowy"),
                    badaniePb,
                    badanieLk,
                    rs.getInt("ekg_rytm"), rs.getInt("ekg_war1"), rs.getBigDecimal("ekg_war2"));
            return badanieEkg;
        } else {
            return null;
        }
    }

    public int dodajBadanieEkg(int wePbId, int weBLk, Date weBDataBad, String weBOpis, int weERytm, int weEWar1, BigDecimal weEWar2) throws SQLException {
        String sql = "select badanie_dodaj_ekg(?, ? ,?, ?, ?, ?, ?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, wePbId);
        mapaParam.put(2, weBLk);
        mapaParam.put(3, new java.sql.Timestamp(weBDataBad.getTime()));
        mapaParam.put(4, weBOpis);
        mapaParam.put(5, weERytm);
        mapaParam.put(6, weEWar1);
        mapaParam.put(7, weEWar2);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        rs.next();
        Integer weIdBad = rs.getInt("badanie_dodaj_ekg");
        return weIdBad;
    }

    public void aktualizujBadanieEkg(int weBId, int weBLk, Date weBDataBad, String weBOpis, int weERytm, int weEWar1, BigDecimal weEWar2) throws SQLException {
        String sql = "select badanie_aktualizuj_ekg(?, ?, ?, ? ,?, ?, ?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, weBId);
        mapaParam.put(2, weBLk);
        mapaParam.put(3, new java.sql.Timestamp(weBDataBad.getTime()));
        mapaParam.put(4, weBOpis);
        mapaParam.put(5, weERytm);
        mapaParam.put(6, weEWar1);
        mapaParam.put(7, weEWar2);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        rs.next();
        rs.getBoolean("badanie_aktualizuj_ekg");
    }

}
