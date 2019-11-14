/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut;

import autobahnmaut.datenbank.*;
import autobahnmaut.model.Abschnitt;
import autobahnmaut.model.FahrtenLaufend;
import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Messdaten;
import autobahnmaut.model.Nutzer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SampleQuery {

    public static void main(String[] args) throws ParseException {
     //   Date monat = Calendar.getInstance().getTime();

        autobahnmaut.datenbank.Datenbank.getConnection();

    //    FahrtenLaufend fahrtenlaufend = new FahrtenLaufend();

//        fahrtenlaufend = autobahnmaut.datenbank.FahrtenManager.getLaufendeFahrt(213);
//                fahrtenlaufend.setAktuelleZeit(monat);
//        fahrtenlaufend.setMautbrueckeRecent(autobahnmaut.datenbank.FahrtenManager.getMautbrueckeById(10));
//        
//        
//       Messdaten messdaten= autobahnmaut.logik.DatenInput.datenUmwandeln("5;14.11.2019;2;ST,GQ,387");
//       
//       Fahrzeug fahrzeug =FahrzeugManager.getFahrzeugByKennzeichenAndLandid(messdaten.getKennzeichen(), messdaten.getLand().getLandId());
//       
//       System.out.println(messdaten.getMautbruecke().getStandort().getStandortID());
//        System.out.println(fahrtenlaufend.getMautbrueckeRecent().getStandort().getStandortID());
//        
//       Abschnitt abschnitt = FahrtenManager.getAbschnittByIds(fahrtenlaufend.getMautbrueckeRecent().getStandort().getStandortID(), messdaten.getMautbruecke().getStandort().getStandortID());
//          System.out.println(abschnitt.getDistanz());
        //fahrtenlaufend= autobahnmaut.logik.DatenInput.laufendeFahrtAktualisieren(autobahnmaut.logik.DatenInput.datenUmwandeln("4;14.11.2019;2;ST,GQ,387"));
        // autobahnmaut.datenbank.FahrtenManager.updateLaufendeFahrtToAbgeschlossen(fahrtenlaufend);
//        Nutzer nutzer = UserManager.getNutzerById(1);
//        nutzer.setName("Deutsche Post AG");
//        UserManager.updateNutzerPasswort(nutzer,"admin3");
//    ArrayList<Fahrzeug> fahrzeugListe = FahrzeugManager.getFahrzeugePolizei();
//    int count=0;
//    for(Fahrzeug f :fahrzeugListe ){
//        f.setKennzeichen("PO,LI,123");
//        FahrzeugManager.updateFahrzeug(f);
//        count++;
//        System.out.println(count);
//        System.out.println(f.getKennzeichen());
//    }
    
//    ArrayList<String> simDaten = FahrtenManager.getSimulatorDaten();
//    int count=0;
//    for(String s :simDaten ){
//        
//        fahrtenlaufend= autobahnmaut.logik.DatenInput.laufendeFahrtAktualisieren(autobahnmaut.logik.DatenInput.datenUmwandeln(s));
//        
//        count++;
//        System.out.println(count);
//        System.out.println(s);
//    }
    
/*       ArrayList<Nutzer> nutzerDaten = UserManager.getNutzerListe();
    int count=0;
    for(Nutzer n :nutzerDaten ){
        
        
        count++;
        System.out.println(count);
        System.out.println(n.getName());
    }
      
 */

    System.out.println(FahrzeugManager.getFahrzeugePolizei().size());
        
        

    }
}
