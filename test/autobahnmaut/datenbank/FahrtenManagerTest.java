/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Abschnitt;
import autobahnmaut.model.FahrtenLaufend;
import autobahnmaut.model.Mautbruecke;
import autobahnmaut.model.Standort;
import java.util.ArrayList;
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
public class FahrtenManagerTest {
    
    public FahrtenManagerTest() {
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
     * Test of getLaufendeFahrt method, of class FahrtenManager.
     */
    @Test
    public void testGetLaufendeFahrt() {
        System.out.println("getLaufendeFahrt");
        int fahrzeugId = 0;
        FahrtenLaufend expResult = null;
        FahrtenLaufend result = FahrtenManager.getLaufendeFahrt(fahrzeugId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getMautbrueckeById method, of class FahrtenManager.
     */
    
    @Test
    public void testGetMautbrueckeById() {
        System.out.println("getMautbrueckeById");
        int mautbrueckeId = 0;
        Mautbruecke expResult = null;
        Mautbruecke result = FahrtenManager.getMautbrueckeById(mautbrueckeId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetMautbrueckeByIdDaten() {
        System.out.println("testGetMautbrueckeByIdDaten");
        
        int mautbrueckeId = 1;
        
        Mautbruecke testMaut = new Mautbruecke();
        Standort testStandort = new Standort();
        
        testStandort.setStandortID(1);
        testStandort.setBezeichnung("Flensburg");
        
        testMaut.setAbfahrt(true);
        testMaut.setMautbrueckeID(1);
        testMaut.setStandort(testStandort);
        
        Mautbruecke m = new Mautbruecke();
        
        m = FahrtenManager.getMautbrueckeById(mautbrueckeId);
        
        assertEquals(m.getMautbrueckeID(), testMaut.getMautbrueckeID());        
    }
    
    @Test
    public void testexistiertMautbrücke() {
        
        boolean Testergebnis = false;
        
        System.out.println("testexistiertMautbrücke");
        
        Mautbruecke testMaut = new Mautbruecke();
        Standort testStandort = new Standort();
        
        testStandort.setStandortID(16);
        testStandort.setBezeichnung("Bautzen");
        
        testMaut.setAbfahrt(true);
        testMaut.setMautbrueckeID(31);
        testMaut.setStandort(testStandort);
        
        Mautbruecke m = new Mautbruecke();
        
        for(int i = 1; i < 33 ; i++){
            m = FahrtenManager.getMautbrueckeById(i);
            if(m.getMautbrueckeID() == testMaut.getMautbrueckeID() && m.getStandort().getStandortID() == m.getStandort().getStandortID()){
                Testergebnis = true;
            }         
        }
        assertTrue(Testergebnis);
    }

    /**
     * Test of getAbschnittByIds method, of class FahrtenManager.
     */
    @Test
    public void testGetAbschnittByIds() {
        System.out.println("getAbschnittByIds");
        int startstandort = 0;
        int endstandort = 0;
        Abschnitt expResult = null;
        Abschnitt result = FahrtenManager.getAbschnittByIds(startstandort, endstandort);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAbschnittByIDDaten(){
        System.out.println("testGetAbschnittByIDDaten");
        
        int AbschnittIdStart = 1;
        int AbschnittIdEnde = 2;
        
        Abschnitt test = new Abschnitt();
        
        Standort start = new Standort();
        Standort ende = new Standort();
        
        start.setBezeichnung("Flensburg");
        start.setStandortID(1);
        
        ende.setBezeichnung("Hamburg");
        ende.setStandortID(2);
        
        test.setAbschnittID(1);
        test.setDistanz(165);
        test.setEndStandort(ende);
        test.setStartStandort(start);
        
        System.out.println(test);
        
        Abschnitt m = new Abschnitt();
        
        m = FahrtenManager.getAbschnittByIds(AbschnittIdStart, AbschnittIdEnde);
        
        assertEquals(m.getAbschnittID(), test.getAbschnittID());
    }
    
    @Test
    public void testexestiertAbschnitt(){
        
        System.out.println("testexestiertAbschnitt");
        
        boolean Testergebnis = false;
        
        int StartAbschnittId = 14;
        int EndAbschnittId = 7;
        
        Abschnitt test = new Abschnitt();
        
        Standort start = new Standort();
        Standort ende = new Standort();
        
        start.setStandortID(14);
        start.setBezeichnung("Kassel");
        
        ende.setStandortID(7);
        ende.setBezeichnung("Frankfurt");
        
        test.setAbschnittID(26);
        test.setDistanz(180);
        test.setEndStandort(ende);
        test.setStartStandort(start);
        
        Abschnitt m = new Abschnitt();
        
        for(int i = 1; i < 17; i++){
            for(int j = 1 ; j < 17 ; j++){
                m = FahrtenManager.getAbschnittByIds(i, j);
                if(m.getAbschnittID() == test.getAbschnittID()){
                    Testergebnis = true;
                }
            }
        }
        assertTrue(Testergebnis);
    }

    /**
     * Test of getStandordById method, of class FahrtenManager.
     */
    
    @Test
    public void testGetStandordById() {
        System.out.println("getStandordById");
        int standordId = 0;
        Standort expResult = null;
        Standort result = FahrtenManager.getStandordById(standordId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetStandortByIdDaten(){
        System.out.println("testGetStandortByIdDaten");
        
        int StandortId = 1;
        
        Standort test = new Standort();
        
        test.setBezeichnung("Flensburg");
        test.setStandortID(1);
        
        Standort m = new Standort();
        
        m = FahrtenManager.getStandordById(StandortId);
        
        assertEquals(test.getBezeichnung(), m.getBezeichnung());        
    }
    
    @Test
    public void testexistiertStandort(){
        
        boolean Testergebnis = false;
        
        System.out.println("testexistiertStandort");
        
        Standort test = new Standort();
        
        test.setStandortID(12);
        test.setBezeichnung("München");
        
        System.out.println(test);
        
        Standort m = new Standort();
        
        for(int i = 1 ; i < 17 ; i++){
            m = FahrtenManager.getStandordById(i);
            if(test.getStandortID() == m.getStandortID()){
                Testergebnis = true;
                break;
            }
        }
        assertTrue(Testergebnis);
    }
    
}
