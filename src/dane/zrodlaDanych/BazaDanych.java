/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dane.zrodlaDanych;

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brybarczyk
 */
public class BazaDanych {

    public Connection polaczBazaDanych() throws SQLException {

        Connection connection = null;

        String url = "jdbc:postgresql://127.0.0.1/PRAKTYKA";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, props);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public ResultSet pobierzDaneZBazyDanych(String zapytanie) throws SQLException {
        Connection con = polaczBazaDanych();
        PreparedStatement prepareStatement = con.prepareStatement(zapytanie);
        ResultSet rs = prepareStatement.executeQuery();
        return rs;
    }
    
    public ResultSet pobierzDaneZBazyDanych(String zapytanie, HashMap<Integer, Object> mapaArg) throws SQLException {
        Connection con = polaczBazaDanych();
        PreparedStatement prepareStatement = con.prepareStatement(zapytanie);

        for (Integer i : mapaArg.keySet()) {
            Object o = mapaArg.get(i);
            prepareStatement.setObject(i, o);
        }
        ResultSet rs = prepareStatement.executeQuery();
        return rs;
    }
}
