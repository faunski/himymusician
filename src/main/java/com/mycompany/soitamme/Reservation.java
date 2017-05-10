/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soitamme;

import static com.mysql.jdbc.StringUtils.split;
import static com.mysql.jdbc.StringUtils.split;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samu
 */
public class Reservation extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("test1");

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        String sdate = request.getParameter("sdate");
        String phone = request.getParameter("phone");
        String url = "www.test.com";
        String message = request.getParameter("message");
        String color = "ffffff";
        String band = "Lucio";
        
                
        String[] split = sdate.split("/");
        String temp = split[0];
        split[0] = split[1];
        split[1] = temp;
        Collections.reverse(Arrays.asList(split));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
            if (i != split.length - 1) {
                sb.append("-");
    }
}
        sdate = sb.toString();
        String edate = sdate;

        try {
            System.out.println("test2");
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://himymusician.cqsscjueysvj.eu-west-1.rds.amazonaws.com:3306/himymusician?" + "user=root&password=starbucks");

        PreparedStatement pst = con.prepareStatement("INSERT INTO events (email, phone, name, startdate, enddate, starttime, endtime, url, message, color, band)" + 
                " VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, email);
            pst.setString(2, phone);
            pst.setString(3, name);
            pst.setString(4, sdate);
            pst.setString(5, edate);
            pst.setString(6, stime);
            pst.setString(7, etime);
            pst.setString(8, url);
            pst.setString(9, message);
            pst.setString(10, color);
            pst.setString(11, band);
            pst.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("test3");
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    }
