/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soitamme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Samu
 */
public class Calendar {
    
    
    public static void newEvent(String email, String pass) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://bits.cqsscjueysvj.eu-west-1.rds.amazonaws.com:3306/project?" + "user=root&password=starbucks");
            PreparedStatement pst = con.prepareStatement("INSERT INTO events " + 
                "VALUES (?,?)");
            pst.setString(1, email);
            pst.setString(2, pass);
            pst.executeUpdate();
       /*     PreparedStatement pst = con.prepareStatement("insert into login values(email=?, pass=?)");
            pst.setString(1, email);
            pst.setString(2, pass);
            pst.executeUpdate();
*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
