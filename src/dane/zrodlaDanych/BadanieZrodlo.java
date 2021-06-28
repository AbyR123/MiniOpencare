/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane.zrodlaDanych;

import dane.Badanie;
import dane.Lekarz;
import dane.Pobyt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author brybarczyk
 */
public class BadanieZrodlo {

    private BazaDanych bd;

    public BadanieZrodlo() {
        bd = new BazaDanych();
    }

    public ArrayList<Badanie> pobierzBadanieListaBD(int wePbId, int weBRId) throws SQLException {
        ArrayList<Badanie> badania = new ArrayList<>();

        String sql = "select * from badanie_pobierz_liste(?, ?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, wePbId);
        mapaParam.put(2, weBRId);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        while (rs.next()) {
            Pobyt badaniePb = new Pobyt(rs.getInt("pobyt_id"));
            Lekarz badanieLk = new Lekarz(rs.getInt("lekarz_opiujacy_id"));
            Badanie badE = new Badanie(rs.getInt("badanie_id"), rs.getDate("data_badania"), rs.getString("wynik_opisowy"), badaniePb, badanieLk);
            badania.add(badE);
        }
        return badania;
    }

    public int usunBadanie(int weBId) throws SQLException {
        String sql = "select * from badanie_usun(?)";
        HashMap<Integer, Object> mapaParam = new HashMap();
        mapaParam.put(1, weBId);
        ResultSet rs = bd.pobierzDaneZBazyDanych(sql, mapaParam);
        rs.next();
        int uBId = rs.getInt("badanie_usun");
        return uBId;
    }
}
