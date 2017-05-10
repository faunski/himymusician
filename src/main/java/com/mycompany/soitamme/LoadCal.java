/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soitamme;

/**
 *
 * @author Samu
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@WebServlet(name = "loadcal", urlPatterns = {"/loadcal"})
public class LoadCal extends HttpServlet {

    public static void doGet(String argv[]) throws ClassNotFoundException, SQLException, ParserConfigurationException, TransformerException {

        // create our mysql database connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://himymusician.cqsscjueysvj.eu-west-1.rds.amazonaws.com:3306/himymusician?" + "user=root&password=starbucks");

        // our SQL SELECT query. 
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM events WHERE id=(SELECT max(id) FROM events)  ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        int max = rs.getInt("id");

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("monthly");
        doc.appendChild(rootElement);

        for (int i = 0; i < max; i++) {
            String queri = "SELECT * FROM events";

            // create the java statement
            Statement sta = con.createStatement();

            // execute the query, and get a java resultset
            ResultSet res = st.executeQuery(queri);
            res.next();
            // iterate through the java resultset
            int id = res.getInt("id");
            Element event = doc.createElement("event");
            rootElement.appendChild(event);

            Attr attr = doc.createAttribute("id");
            attr.setValue(Integer.toString(id));
            event.setAttributeNode(attr);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(res.getString("name")));
            event.appendChild(name);

            Element sdate = doc.createElement("startdate");
            sdate.appendChild(doc.createTextNode(res.getString("startdate")));
            event.appendChild(sdate);

            Element edate = doc.createElement("enddate");
            edate.appendChild(doc.createTextNode(res.getString("enddate")));
            event.appendChild(edate);

            Element stime = doc.createElement("starttime");
            stime.appendChild(doc.createTextNode(res.getString("starttime")));
            event.appendChild(stime);

            Element etime = doc.createElement("endtime");
            etime.appendChild(doc.createTextNode(res.getString("endtime")));
            event.appendChild(etime);

            Element color = doc.createElement("color");
            etime.appendChild(doc.createTextNode(res.getString("color")));
            event.appendChild(color);

            Element url = doc.createElement("url");
            etime.appendChild(doc.createTextNode(res.getString("url")));
            event.appendChild(url);

            rootElement.appendChild(event);

        }

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("events.xml"));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);

        System.out.println("File saved!");

    }

}
