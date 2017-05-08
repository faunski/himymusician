/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soitamme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kimi
 */
public class Search {
    
    private String query, band, search;
    
    
    public ArrayList<String> searchGenre(String searchGenre) throws SQLException {
        ArrayList<String> bands = new ArrayList<String>();
        Statement stmt = null;
        search = searchGenre.toUpperCase();
        Connection con = DriverManager.getConnection("jdbc:mysql://himymusician.cqsscjueysvj.eu-west-1.rds.amazonaws.com:3306?" + "user=root&password=starbucks");
        
        query = "select " + search + "from ";
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                band = rs.getString(search);
                bands.add(band);
            }
        } catch (SQLException e) {
            System.out.println("error");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return bands;
    }
}
