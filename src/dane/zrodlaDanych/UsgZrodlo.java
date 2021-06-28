/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane.zrodlaDanych;

import dane.Lekarz;
import dane.Pobyt;
import dane.Usg;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 */
public class UsgZrodlo {

    private BazaDanych bd;

    public UsgZrodlo() {
        bd = new BazaDanych();
    }

    public Usg pobierzBadanieUsgBD(int weBId) throws SQLException {
        String sql = "select * from badanie_pobierz_usg(?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, weBId);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        if (rs.next()) {
            Pobyt badaniePb = new Pobyt(rs.getInt("pobyt_id"));
            Lekarz badanieLk = new Lekarz(rs.getInt("lekarz_opiujacy_id"));
            Usg badanieUsg = new Usg(rs.getInt("badanie_id"), rs.getTimestamp("data_badania"), rs.getString("wynik_opisowy"),
                    badaniePb,
                    badanieLk,
                    rs.getInt("usg_nazwa_Id"),
                    rs.getString("usg_nazwa"));
            return badanieUsg;
        } else {
            return null;
        }
    }

    public ArrayList<Usg> pobierzNazwyWynikowUsg() throws SQLException {
        ArrayList<Usg> nwu = new ArrayList<Usg>();
        String query = "SELECT id, nazwa from public.s_usg order by id asc limit 10;";
        ResultSet rs = bd.pobierzDaneZBazyDanych(query);
        while (rs.next()) {
            Usg n = new Usg(rs.getInt("id"), rs.getString("nazwa"));
            nwu.add(n);
        }
        return nwu;
    }

    public int dodajBadanieUsg(int wePbId, int weBLk, Date weBDataBad, String weBOpis, int weUNId) throws SQLException {
        String sql = "select badanie_dodaj_usg(?, ? ,?, ?, ?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, wePbId);
        mapaParam.put(2, weBLk);
        mapaParam.put(3, new java.sql.Timestamp(weBDataBad.getTime()));
        mapaParam.put(4, weBOpis);
        mapaParam.put(5, weUNId);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        rs.next();
        Integer weIdBad = rs.getInt("badanie_dodaj_usg");
        return weIdBad;
    }

    public void aktualizujBadanieUsg(int weBId, int weBLk, Date weBDataBad, String weBOpis, int weUNId) throws SQLException {
        String sql = "select badanie_aktualizuj_usg(?, ?, ?, ? ,?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, weBId);
        mapaParam.put(2, weBLk);
        mapaParam.put(3, new java.sql.Timestamp(weBDataBad.getTime()));
        mapaParam.put(4, weBOpis);
        mapaParam.put(5, weUNId);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        rs.next();
        rs.getBoolean("badanie_aktualizuj_usg");
    }
}
