/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Statistik;
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
public class StatistikManagerTest {
    
    public StatistikManagerTest() {
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
     * Test of getStatistikdaten method, of class StatistikManager.
     */
    @Test
    public void testGetStatistikdaten() {
        System.out.println("getStatistikdaten");
        Statistik expResult = null;
        Statistik result = StatistikManager.getStatistikdaten();
        assertEquals(expResult, result);
    }
    
}
