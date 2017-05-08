/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.soitamme.Search;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class will be used to test the search.java
 * @author Kimi
 */
public class SearchTester {
    
    @Test
    public void testConnection() throws ClassNotFoundException, SQLException {
        ArrayList<String> list = new ArrayList<String>();
        Search search = new Search();
        list = search.searchGenre("jazz");
        assertEquals(list.get(0), "asd");
    }
    
}
