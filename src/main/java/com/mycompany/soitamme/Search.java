/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soitamme;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
        search = searchGenre;
        Connection con = DriverManager.getConnection("jdbc:mysql://himymusician.cqsscjueysvj.eu-west-1.rds.amazonaws.com:3306/himymusician?" + "user=root&password=starbucks");
        if (search.equals("All")){
            query = "SELECT * FROM band";
        } else {
        query = "SELECT * FROM band WHERE genre ='"+ search +"'";
        }
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                band = rs.getString("name");
                bands.add(band);
            }
            for (String banda : bands) {
                rs = stmt.executeQuery("SELECT * FROM band WHERE NAME ='"+banda+"'");
                //check these in db to make sure theyre right
                while(rs.next()){
                name = rs.getString("name");
                genre = rs.getString("genre");
                link = rs.getString("url");
                
                bandsInfo.add(new Band(name, genre, link));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return bandsInfo;
    }

}


