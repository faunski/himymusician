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
    
    
    public ArrayList<Band> searchGenre(String searchGenre) throws SQLException {
        ArrayList<String> bands = new ArrayList<String>();
        ArrayList<Band> bandsInfo = new ArrayList<Band>();
        ResultSet rs;
        String name, genre, email, phone, link;
        
        Statement stmt = null;
        search = searchGenre.toUpperCase();
        Connection con = DriverManager.getConnection("jdbc:mysql://himymusician.cqsscjueysvj.eu-west-1.rds.amazonaws.com:3306?" + "user=root&password=starbucks");
        
        query = "select " + search + "from BANDS";
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                band = rs.getString(search);
                bands.add(band);
            }
            for (String band : bands) {
                rs = stmt.executeQuery("select " + band + "from BANDS");
                //check these in db to make sure theyre right
                name = rs.getString("NAME");
                genre = rs.getString("GENRE");
                email = rs.getString("EMAIL");
                phone = rs.getString("PHONE");
                link = rs.getString("LINK");
                
                bandsInfo.add(new Band(name, genre, email, phone, link));
            }
        } catch (SQLException e) {
            System.out.println("error");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return bandsInfo;
    }
}
