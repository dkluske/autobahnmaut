/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Land;
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
public class LandManagerTest {
    
    public LandManagerTest() {
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
     * Test of getLandById method, of class LandManager.
     */
    @Test // LandID 0 --> Rückgabewert null
    public void testGetLandById() {
        System.out.println("getLandById");
        int landId = 0;
        Land expResult = null;
        Land result = LandManager.getLandById(landId);
        assertEquals(expResult, result);
    }
    
    @Test // Land definiert --> Methode söllte selbe Daten zurück geben
    public void testGetLandByIDDaten(){
        System.out.println("testGetLandByIDDaten");
        
        Land test = new Land();
        
        test.setLandId(2);
        test.setBezeichnung("NiederLande");
        test.setKurzBezeichnung("NL");
        
        Land n = new Land();
        
        n = LandManager.getLandById(1);
        
        assertEquals(n.getBezeichnung(), test.getBezeichnung());
    }
    
    @Test // Land definiert --> söllte in DB vorhanden sein
    public void testexistiertLand(){
        System.out.println("testexistiertLand");
        
        boolean Testergebnis = false;
        
        Land test = new Land();
        
        test.setLandId(6);
        test.setBezeichnung("Frankreich");
        test.setKurzBezeichnung("F");
        
        Land n = new Land();
              
        for(int i = 1; i < 17; i++){   
           n = LandManager.getLandById(i);
           if(n.getLandId() == test.getLandId()){
                Testergebnis = true;
                break;
            }
        }
        assertTrue(Testergebnis);
        
    } 
}
