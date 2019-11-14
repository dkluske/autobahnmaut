/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Nutzer;
import autobahnmaut.model.Rechnung;
import java.util.ArrayList;
import java.util.Date;
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
public class UserManagerTest {
    
    public UserManagerTest() {
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
     * Test of login method, of class UserManager.
     */
    
   @Test // Leere email und passwort --> Rückgabewert null
    public void testLoginNull() {
        System.out.println("LoginNullwert");
        String email = "";
        String passwort = "";
        Nutzer expResult = null;
        Nutzer result = UserManager.login(email, passwort);
        assertEquals(expResult, result);
    }
    
    @Test // Nutzer definiert --> LoginMethode söllte selbe Daten zurück geben
    public void testLoginNutzer()
    {
        System.out.println("LoginNutzer");
        
        Nutzer Test = new Nutzer();
        
        Test.setNutzerId(1);
        Test.setEmail("abrechnung@post.de");
        Test.setName("Deutschen Post AG");
        Test.setOrt("Faxsee");
        Test.setPlz("79997");
        Test.setRabatt(1);
        Test.setRolle("Nutzer");
        Test.setStrasse("Brandenburgische Strasse 77");
        
        Nutzer n = new Nutzer();
        
        n = UserManager.login("abrechnung@post.de", "admin");
              
        assertEquals(n.getName(), Test.getName());        
    }

    /*
     * Test of getNutzerById method, of class UserManager.
     */
    
    @Test // Login mit falschen Passwort --> Rückgabe null
    public void testLoginfalschesPasswort(){
        
        System.out.println("testLoginfalschesPasswort");
        
        String email = "abrechnung@post.de";
        String passwort = "amin";
        
        Nutzer expResult = null;
        Nutzer result = UserManager.login(email, passwort);
        
        assertEquals(expResult, result);
    }
    
    @Test // Login mit falscher email --> Rückgabewert null
    public void testLoginfalscheEmail(){
        
        System.out.println("testLoginfalscheEmail");
        
        String email = "abrechnung@post.com";
        String passwort = "admin";
        
        Nutzer expResult = null;
        Nutzer result = UserManager.login(email, passwort);
        
        assertEquals(expResult, result);
    }
    
    @Test // NutzerID 0 --> Rückgabewert 0
    public void testGetNutzerByIdNull() {
        System.out.println("getNutzerByIdNull");
        int nutzerId = 0;
        Nutzer expResult = null;
        Nutzer result = UserManager.getNutzerById(nutzerId);
        assertEquals(expResult, result);
    } 
       
    @Test // Nutzer wurde definiert --> Methode söllte selbe Werte zurück geben
    public void testGetNutzerByIDWert(){
        System.out.println("testGetNutzerByIdWert");
        
        int nutzerID = 1;
        
        Nutzer Test = new Nutzer();
        
        Test.setNutzerId(1);
        Test.setEmail("abrechnung@post.de");
        Test.setName("Deutsche Post AG");
        Test.setOrt("Faxsee");
        Test.setPlz("79997");
        Test.setRabatt(1.0);
        Test.setRolle("Nutzer");
        Test.setStrasse("Brandenburgische Strasse 77");
         
       Nutzer n = new Nutzer();
       
       n = UserManager.getNutzerById(1);
       
       assertEquals(Test.getName(),n.getName());
    }
    
    @Test // Nutzer wurde definiert --> Test ob in DB vorhanden
    public void testexestiertNutzer(){
        
        boolean Testergebnis = false;
        
        Nutzer test = new Nutzer();
        
        test.setEmail("hausmeister@fritzbitzbert.com");
        test.setName("Hausmeister Fritzbert");
        test.setNutzerId(13);
        test.setOrt("Pullerbrück");
        test.setPlz("73748");
        test.setRabatt(1.0);
        test.setRolle("Nutzer");
        test.setStrasse("Bleibtreustrasse 66");
        
        Nutzer n = new Nutzer();
        
        for(int i = 1; i < 18 ; i++){
            n = UserManager.getNutzerById(i);
            if(n.getNutzerId() == test.getNutzerId()){
                Testergebnis = true;
                break;
            }
        }
        assertTrue(Testergebnis);
    } 
}
