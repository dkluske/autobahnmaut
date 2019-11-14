/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import java.sql.Connection;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 17wi1115
 */
public class DatenbankTest {
    
    public DatenbankTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class Datenbank.
     */
    @Test // Verbindung sollte klappen, deshalb darf rückgabewert nicht null sein
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = Datenbank.getConnection();
        assertNotNull(result);
    }
    
    /*
     * Test of getStatement method, of class Datenbank.
     */
    
    @Test // Verbindung sollte klappen, deshalb darf rückgabewert nicht null sein
    public void testGetStatement() {
        System.out.println("getStatement");
        Statement result = Datenbank.getStatement();
        assertNotNull(result);
    }
    
}
