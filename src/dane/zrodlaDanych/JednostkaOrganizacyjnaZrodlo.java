/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane.zrodlaDanych;

import dane.JednostkaOrganizacyjna;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author brybarczyk
 */


public class JednostkaOrganizacyjnaZrodlo {
    private BazaDanych bd;    
    
    public JednostkaOrganizacyjnaZrodlo() {
        bd = new BazaDanych();
    }
    
    public ArrayList<JednostkaOrganizacyjna> pobierzJednostki() throws SQLException {
        ArrayList<JednostkaOrganizacyjna> jos = new ArrayList<JednostkaOrganizacyjna>();
        
        
        String query = "SELECT id, nazwa from dane.jednostki_organizacyjne where typ_id=2 limit 10;";
        ResultSet rs = bd.pobierzDaneZBazyDanych(query);
        while (rs.next()) {
            JednostkaOrganizacyjna jo = new JednostkaOrganizacyjna(rs.getInt("id"), rs.getString("nazwa"));
            jos.add(jo);
        }
        
        return jos;
    }

}
