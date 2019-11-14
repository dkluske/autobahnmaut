/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Land;
import autobahnmaut.model.Nutzer;
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
public class FahrzeugManagerTest {
    
    public FahrzeugManagerTest() {
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
     * Test of fahrzeuglisteNutzer method, of class FahrzeugManager.
     */
    @Test // Leerer Nutzer --> Leere Fahrzeugliste
    public void testFahrzeuglisteNutzer() {
        System.out.println("fahrzeuglisteNutzer");
        int nutzerId = 0;
        ArrayList<Fahrzeug> expResult = new ArrayList<Fahrzeug>();
        ArrayList<Fahrzeug> result = FahrzeugManager.fahrzeuglisteNutzer(nutzerId);
        assertEquals(expResult, result);
    }
    
    @Test // Fahrzeugliste wurde definiert --> durch funktion wird eine abgerufen. Funktioniert nicht 
    public void testFahrzeuglisteNutzerDaten() {
        
        System.out.println("testFahrzeuglisteNutzerDaten");
        
        ArrayList<Fahrzeug> testliste = new ArrayList();
        
        int nutzerId = 15;
        
        Fahrzeug testfahrzeug1 = new Fahrzeug();
        Fahrzeug testfahrzeug2 = new Fahrzeug();
        Fahrzeug testfahrzeug3 = new Fahrzeug();
        Fahrzeug testfahrzeug4 = new Fahrzeug();
        Fahrzeug testfahrzeug5 = new Fahrzeug();
        Fahrzeug testfahrzeug6 = new Fahrzeug();
        Fahrzeug testfahrzeug7 = new Fahrzeug();
        Fahrzeug testfahrzeug8 = new Fahrzeug();
        Fahrzeug testfahrzeug9 = new Fahrzeug();
        Fahrzeug testfahrzeug10 = new Fahrzeug();
        Fahrzeug testfahrzeug11 = new Fahrzeug();
        Fahrzeug testfahrzeug12 = new Fahrzeug();
        Fahrzeug testfahrzeug13 = new Fahrzeug();
        Fahrzeug testfahrzeug14 = new Fahrzeug();
        Fahrzeug testfahrzeug15 = new Fahrzeug();
        Fahrzeug testfahrzeug16 = new Fahrzeug();
        Fahrzeug testfahrzeug17 = new Fahrzeug();
        Fahrzeug testfahrzeug18 = new Fahrzeug();
        Fahrzeug testfahrzeug19 = new Fahrzeug();
        Fahrzeug testfahrzeug20 = new Fahrzeug();
        
        Land deutschland = new Land();
        deutschland.setLandId(1);
        deutschland.setKurzBezeichnung("D");
        deutschland.setBezeichnung("Deutschland");
        
        Land luxemburg = new Land();
        luxemburg.setLandId(4);
        luxemburg.setKurzBezeichnung("L");
        luxemburg.setBezeichnung("Luxemburg");
        
        Land frankreich = new Land();
        frankreich.setLandId(5);
        frankreich.setKurzBezeichnung("F");
        frankreich.setBezeichnung("Frankreich");
        
        Land tschechin = new Land();
        tschechin.setLandId(8);
        tschechin.setKurzBezeichnung("CZ");
        tschechin.setBezeichnung("Tschechien");
        
        Land polen = new Land();
        polen.setLandId(9);
        polen.setKurzBezeichnung("P");
        polen.setBezeichnung("Polen");
        
        Land daenemark = new Land();
        daenemark.setLandId(10);
        daenemark.setKurzBezeichnung("DK");
        daenemark.setBezeichnung("Dänemark");
        
        Land spanien = new Land();
        spanien.setLandId(16);
        spanien.setKurzBezeichnung("E");
        spanien.setBezeichnung("Spanien");
                
        Nutzer admin = new Nutzer();
        admin.setEmail("admin@admin.de");
        admin.setName("admin");
        admin.setNutzerId(17);
        admin.setOrt("Bautzen");
        admin.setPlz("94191");
        admin.setRabatt(1);
        admin.setRolle("Admin");
        admin.setStrasse("Jenaer Strasse 49");
        
        testfahrzeug1.setFahrzeugId(9);
        testfahrzeug1.setKennzeichen("CS,GC,761");
        testfahrzeug1.setLand(deutschland);
        testfahrzeug1.setNutzer(admin);
        testfahrzeug1.setPrivileg(false);
        
        testfahrzeug2.setFahrzeugId(30);
        testfahrzeug2.setKennzeichen("VQ,PS,578");
        testfahrzeug2.setLand(luxemburg);
        testfahrzeug2.setNutzer(admin);
        testfahrzeug2.setPrivileg(false);
        
        testfahrzeug3.setFahrzeugId(37);
        testfahrzeug3.setKennzeichen("GV,VD,620");
        testfahrzeug3.setLand(frankreich);
        testfahrzeug3.setNutzer(admin);
        testfahrzeug3.setPrivileg(false);
        
        testfahrzeug4.setFahrzeugId(62);
        testfahrzeug4.setKennzeichen("QN,CI,48");
        testfahrzeug4.setLand(tschechin);
        testfahrzeug4.setNutzer(admin);
        testfahrzeug4.setPrivileg(false);
        
        testfahrzeug5.setFahrzeugId(68);
        testfahrzeug5.setKennzeichen("UH,RR,622");
        testfahrzeug5.setLand(tschechin);
        testfahrzeug5.setNutzer(admin);
        testfahrzeug5.setPrivileg(false);
        
        testfahrzeug6.setFahrzeugId(69);
        testfahrzeug6.setKennzeichen("HG,UC,353");
        testfahrzeug6.setLand(tschechin);
        testfahrzeug6.setNutzer(admin);
        testfahrzeug6.setPrivileg(false);
        
        testfahrzeug7.setFahrzeugId(75);
        testfahrzeug7.setKennzeichen("JY,EB,788");
        testfahrzeug7.setLand(polen);
        testfahrzeug7.setNutzer(admin);
        testfahrzeug7.setPrivileg(false);
        
        testfahrzeug8.setFahrzeugId(98);
        testfahrzeug8.setKennzeichen("IG,SR,517");
        testfahrzeug8.setLand(daenemark);
        testfahrzeug8.setNutzer(admin);
        testfahrzeug8.setPrivileg(false);
        
        testfahrzeug9.setFahrzeugId(151);
        testfahrzeug9.setKennzeichen("VA,RW,655");
        testfahrzeug9.setLand(spanien);
        testfahrzeug9.setNutzer(admin);
        testfahrzeug9.setPrivileg(false);
        
        testfahrzeug10.setFahrzeugId(155);
        testfahrzeug10.setKennzeichen("KK,VR,225");
        testfahrzeug10.setLand(spanien);
        testfahrzeug10.setNutzer(admin);
        testfahrzeug10.setPrivileg(false);
        
        testfahrzeug11.setFahrzeugId(164);
        testfahrzeug11.setKennzeichen("RH,OP,875");
        testfahrzeug11.setLand(deutschland);
        testfahrzeug11.setNutzer(admin);
        testfahrzeug11.setPrivileg(true);
        
        testfahrzeug12.setFahrzeugId(171);
        testfahrzeug12.setKennzeichen("SE,WT,393");
        testfahrzeug12.setLand(deutschland);
        testfahrzeug12.setNutzer(admin);
        testfahrzeug12.setPrivileg(true);
        
        testfahrzeug13.setFahrzeugId(187);
        testfahrzeug13.setKennzeichen("UP,JG,158");
        testfahrzeug13.setLand(deutschland);
        testfahrzeug13.setNutzer(admin);
        testfahrzeug13.setPrivileg(true);
        
        testfahrzeug14.setFahrzeugId(199);
        testfahrzeug14.setKennzeichen("SA,KR,455");
        testfahrzeug14.setLand(deutschland);
        testfahrzeug14.setNutzer(admin);
        testfahrzeug14.setPrivileg(true);
        
        testfahrzeug15.setFahrzeugId(207);
        testfahrzeug15.setKennzeichen("WI,BZ,61");
        testfahrzeug15.setLand(deutschland);
        testfahrzeug15.setNutzer(admin);
        testfahrzeug15.setPrivileg(true);
        
        testfahrzeug16.setFahrzeugId(208);
        testfahrzeug16.setKennzeichen("TC,PO,789");
        testfahrzeug16.setLand(deutschland);
        testfahrzeug16.setNutzer(admin);
        testfahrzeug16.setPrivileg(true);
        
        testfahrzeug17.setFahrzeugId(218);
        testfahrzeug17.setKennzeichen("KS,PF,559");
        testfahrzeug17.setLand(deutschland);
        testfahrzeug17.setNutzer(admin);
        testfahrzeug17.setPrivileg(true);
        
        testfahrzeug18.setFahrzeugId(225);
        testfahrzeug18.setKennzeichen("NB,WO,272");
        testfahrzeug18.setLand(deutschland);
        testfahrzeug18.setNutzer(admin);
        testfahrzeug18.setPrivileg(true);
        
        testfahrzeug19.setFahrzeugId(243);
        testfahrzeug19.setKennzeichen("AW,BO,975");
        testfahrzeug19.setLand(deutschland);
        testfahrzeug19.setNutzer(admin);
        testfahrzeug19.setPrivileg(true);
        
        testfahrzeug20.setFahrzeugId(251);
        testfahrzeug20.setKennzeichen("ZT,LH,168");
        testfahrzeug20.setLand(deutschland);
        testfahrzeug20.setNutzer(admin);
        testfahrzeug20.setPrivileg(true);
        
        testliste.add(testfahrzeug1);
        testliste.add(testfahrzeug2);
        testliste.add(testfahrzeug3);
        testliste.add(testfahrzeug4);
        testliste.add(testfahrzeug5);
        testliste.add(testfahrzeug6);
        testliste.add(testfahrzeug7);
        testliste.add(testfahrzeug8);
        testliste.add(testfahrzeug9);
        testliste.add(testfahrzeug10);
        testliste.add(testfahrzeug11);
        testliste.add(testfahrzeug12);
        testliste.add(testfahrzeug13);
        testliste.add(testfahrzeug14);
        testliste.add(testfahrzeug15);
        testliste.add(testfahrzeug16);
        testliste.add(testfahrzeug17);
        testliste.add(testfahrzeug18);
        testliste.add(testfahrzeug19);
        testliste.add(testfahrzeug20);
        
        ArrayList<Fahrzeug> fahrzeugListe = new ArrayList<>();
        
        fahrzeugListe = FahrzeugManager.fahrzeuglisteNutzer(nutzerId);
        
        assertEquals(testliste, fahrzeugListe);
        
    }
    
    @Test // Anzahl der Fahrzeuge von 15 = 20
    public void testFahrzeuglisteAnzahl(){
        System.out.println("testFahrzeuglisteAnzahl");
        int AnzFahrzeug = FahrzeugManager.fahrzeuglisteNutzer(15).size();
        int Erwartet = 20;
        
        assertEquals(AnzFahrzeug, Erwartet);
    }

    /**
     * Test of getLandById method, of class FahrzeugManager.
     */
    @Test // LandId 0 --> Kann kein Land zurück geben
    public void testGetLandById() {
        System.out.println("getLandById");
        int landId = 0;
        Land expResult = null;
        Land result = FahrzeugManager.getLandById(landId);
        assertEquals(expResult, result);
    }
    
    @Test // Land wurde definiert --> Funktion sollte selbe Werte zurück geben
    public void testGetLandByIdDaten(){
        
        System.out.println("testGetLandByIdDaten");
        
        int LandId = 13;
        
        Land test = new Land();
        
        test.setLandId(13);
        test.setKurzBezeichnung("HR");
        test.setBezeichnung("Kroatien");
        
        Land m = new Land();
        
        m = FahrzeugManager.getLandById(LandId);
        
        assertEquals(test.getBezeichnung(), m.getBezeichnung());       
    }
    
    @Test // Land wurde definiert --> Sollte in DB vorhanden sein
    public void testLandvorhanden(){
        
        boolean Testergebnis = false;
        
        System.out.println("testLandvorhanden");
        
        Land test = new Land();
        
        test.setBezeichnung("Dänemark");
        test.setKurzBezeichnung("DK");
        test.setLandId(10);
        
        Land m = new Land();
        
        for(int i = 1; i < 17 ; i++){
            m = FahrzeugManager.getLandById(i);
            if(m.getLandId() == test.getLandId()){
                Testergebnis =  true;
                break;
            }
        }
        assertTrue(Testergebnis);
    }

    /**
     * Test of getFahrzeugById method, of class FahrzeugManager.
     */
    @Test // FahrzeugId 0 --> Rückgabewert null
    public void testGetFahrzeugById() {
        System.out.println("getFahrzeugById");
        int fahrzeugid = 0;
        Fahrzeug expResult = null;
        Fahrzeug result = FahrzeugManager.getFahrzeugById(fahrzeugid);
        assertEquals(expResult, result);
    }
    
    @Test // FahrzeugId nicht vorhanden --> Rückgabewert null
    public void testGetFahrzeugunbekannteId(){
        
        System.out.println("testGetFahrzeugunbekannteId");
        
        int fahrzeugid = 9999; 
        Fahrzeug expResult = null;
        Fahrzeug result = FahrzeugManager.getFahrzeugById(fahrzeugid);
        assertEquals(expResult, result);
    }
    
    @Test // Fahrzeug definiert --> Methode sollten selbe Werte zurück geben
    public void testGetFahrzeugByIdDaten(){
        
        System.out.println("testGetFahrzeugByIdDaten");
        
        int fahrzeugId = 2;
        
        Nutzer testNutzer = new Nutzer();
        
        testNutzer.setEmail("abrechnung@swarovski.de");
        testNutzer.setName("Swarovski");
        testNutzer.setNutzerId(11);
        testNutzer.setOrt("Vottenstein");
        testNutzer.setPlz("46587");
        testNutzer.setRabatt(1);
        testNutzer.setRolle("Nutzer");
        testNutzer.setStrasse("Ruschestrasse 92");
        
        Land testLand = new Land();
        
        testLand.setBezeichnung("NiederLande");
        testLand.setKurzBezeichnung("NL");
        testLand.setLandId(2);
        
        Fahrzeug test = new Fahrzeug();
        
        test.setFahrzeugId(2);
        test.setKennzeichen("SL,WS,18");
        test.setLand(testLand);
        test.setNutzer(testNutzer);
        test.setPrivileg(true);
        
        Fahrzeug n = new Fahrzeug();
        
        n = FahrzeugManager.getFahrzeugById(fahrzeugId);
        
        assertEquals(test.getKennzeichen(), n.getKennzeichen());
    }
    
    @Test  // Fahrzeug wurde definiert --> Sollte in DB vorhanden sein
    public void testFahrzeugvorhanden(){
        
        boolean Testergebnis = false;
        
        System.out.println("testFahrzeugvorhanden");
        
        Nutzer testNutzer = new Nutzer();
        
        testNutzer.setEmail("abrechnung@bosch.de");
        testNutzer.setName("Bosch");
        testNutzer.setNutzerId(8);
        testNutzer.setOrt("Fusen");
        testNutzer.setPlz("63418");
        testNutzer.setRabatt(1);
        testNutzer.setRolle("Nutzer");
        testNutzer.setStrasse("Schoenebergerstrasse 3");
        
        Land testLand = new Land();
        testLand.setBezeichnung("DeutschLand");
        testLand.setKurzBezeichnung("D");
        testLand.setLandId(1);
        
        Fahrzeug test = new Fahrzeug();
        test.setFahrzeugId(201);
        test.setKennzeichen("ML,OV,652");
        test.setLand(testLand);
        test.setNutzer(testNutzer);
        test.setPrivileg(true);
        
        Fahrzeug n = new Fahrzeug();
        
        for(int i = 1; i < 261 ; i++){
            n = FahrzeugManager.getFahrzeugById(i);
        
            if(test.getFahrzeugId() == n.getFahrzeugId()){
                Testergebnis = true;
                break;
            }
        }
        assertTrue(Testergebnis);
    }

    /**
     * Test of getFahrzeugByKennzeichenAndLandid method, of class FahrzeugManager.
     */
    @Test // Kennzeichen und LandID 0 --> Rückgabewert null
    public void testGetFahrzeugByKennzeichenAndLandid() {
        System.out.println("getFahrzeugByKennzeichenAndLandid");
        String kennzeichen = "";
        int landid = 0;
        Fahrzeug expResult = null;
        Fahrzeug result = FahrzeugManager.getFahrzeugByKennzeichenAndLandid(kennzeichen, landid);
        assertEquals(expResult, result);
    }
    
    @Test // Fahrzeug definiert --> Methode söllte selbe Werte zurück geben
    public void testGetFahrzeugByKennzeichenAndLandidDaten() {
        
        System.out.println("testGetFahrzeugByKennzeichenAndLandidDaten");
        
        int fahrzeugId = 2;
        
        Nutzer testNutzer = new Nutzer();
        
        testNutzer.setEmail("abrechnung@swarovski.de");
        testNutzer.setName("Swarovski");
        testNutzer.setNutzerId(11);
        testNutzer.setOrt("Vottenstein");
        testNutzer.setPlz("46587");
        testNutzer.setRabatt(1);
        testNutzer.setRolle("Nutzer");
        testNutzer.setStrasse("Ruschestrasse 92");
        
        Land testLand = new Land();
        
        testLand.setBezeichnung("NiederLande");
        testLand.setKurzBezeichnung("NL");
        testLand.setLandId(2);
        
        Fahrzeug test = new Fahrzeug();
        
        test.setFahrzeugId(262);
        test.setKennzeichen("SL,WS,18");
        test.setLand(testLand);
        test.setNutzer(testNutzer);
        test.setPrivileg(true);
        
        Fahrzeug n = new Fahrzeug();
        
        n = FahrzeugManager.getFahrzeugByKennzeichenAndLandid("SL,WS,18", 2);
        
        assertEquals(test.getFahrzeugId(), n.getFahrzeugId());
    }
    
    @Test // Länge der Polizeiliste = 22
    public void testgetFahrzeugPolizei(){
        System.out.println("testgetFahrzeugPolizei");
        int AnzPolizei = FahrzeugManager.getFahrzeugePolizei().size();
        int Erwartet = 22;
        
        assertEquals(AnzPolizei, Erwartet);
    }
    
}
