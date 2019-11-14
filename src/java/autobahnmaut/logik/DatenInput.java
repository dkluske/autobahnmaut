
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.logik;

import autobahnmaut.datenbank.FahrtenManager;
import autobahnmaut.datenbank.FahrzeugManager;
import autobahnmaut.model.FahrtenLaufend;
import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Messdaten;
//import com.sun.xml.rpc.processor.modeler.j2ee.xml.genericBooleanType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 17wi1188
 */
public class DatenInput {

    public static Messdaten datenUmwandeln(String simulatordaten) throws ParseException {
        Messdaten messdaten = new Messdaten();
        String[] messdatenArray = simulatordaten.split(";");

        messdaten.setMautbruecke(FahrtenManager.getMautbrueckeById(Integer.parseInt(messdatenArray[0])));
        Date messzeit = new SimpleDateFormat("dd.MM.yyyy").parse(messdatenArray[1]);
        messdaten.setMessZeit(messzeit);
        messdaten.setLand(FahrzeugManager.getLandById(Integer.parseInt(messdatenArray[2])));
        messdaten.setKennzeichen(messdatenArray[3]);

        messdaten.setFahrzeug(FahrzeugManager.getFahrzeugByKennzeichenAndLandid(messdaten.getKennzeichen(), messdaten.getLand().getLandId()));

        return messdaten;
    }

    public static FahrtenLaufend laufendeFahrtAktualisieren(Messdaten messdaten) {
        FahrtenLaufend aktuelleFahrt ;

        if (FahrtenManager.getLaufendeFahrt(messdaten.getFahrzeug().getFahrzeugId()) != null) {
            aktuelleFahrt = FahrtenManager.getLaufendeFahrt(messdaten.getFahrzeug().getFahrzeugId());
            double abstand;
            if (FahrtenManager.getAbschnittByIds(aktuelleFahrt.getMautbrueckeRecent().getStandort().getStandortID(), messdaten.getMautbruecke().getStandort().getStandortID()) == null) {
                FahrtenManager.updateLaufendeFahrtToAbgeschlossen(aktuelleFahrt);
                aktuelleFahrt = new FahrtenLaufend();
                aktuelleFahrt.setAktuelleZeit(messdaten.getMessZeit());
                aktuelleFahrt.setFahrzeug(messdaten.getFahrzeug());
                aktuelleFahrt.setKilometer(0);
                aktuelleFahrt.setMautbrueckeRecent(messdaten.getMautbruecke());
                aktuelleFahrt.setMautbrueckeStart(messdaten.getMautbruecke());
                aktuelleFahrt.setStartZeit(messdaten.getMessZeit());
                FahrtenManager.createNewLaufendeFahrt(aktuelleFahrt);

            } else {
                abstand = FahrtenManager.getAbschnittByIds(aktuelleFahrt.getMautbrueckeRecent().getStandort().getStandortID(), messdaten.getMautbruecke().getStandort().getStandortID()).getDistanz();
                
                aktuelleFahrt.setKilometer(aktuelleFahrt.getKilometer() + abstand);
                aktuelleFahrt.setMautbrueckeRecent(messdaten.getMautbruecke());
                aktuelleFahrt.setAktuelleZeit(messdaten.getMessZeit());
                FahrtenManager.updateLaufendeFahrt(aktuelleFahrt);
                if (aktuelleFahrt.getMautbrueckeStart().isAbfahrt() != aktuelleFahrt.getMautbrueckeRecent().isAbfahrt()) {
                    FahrtenManager.updateLaufendeFahrtToAbgeschlossen(aktuelleFahrt);
                }
            }
        } else {
            aktuelleFahrt = new FahrtenLaufend();
            aktuelleFahrt.setAktuelleZeit(messdaten.getMessZeit());
            aktuelleFahrt.setFahrzeug(messdaten.getFahrzeug());
            aktuelleFahrt.setKilometer(0);
            aktuelleFahrt.setMautbrueckeRecent(messdaten.getMautbruecke());
            aktuelleFahrt.setMautbrueckeStart(messdaten.getMautbruecke());
            aktuelleFahrt.setStartZeit(messdaten.getMessZeit());
            FahrtenManager.createNewLaufendeFahrt(aktuelleFahrt);
        }
        return aktuelleFahrt;
    }
    public static void simulatorDatenHochladen(){
       ArrayList<String> simDaten = FahrtenManager.getSimulatorDaten();       
       for (String s:simDaten){
           try {
               autobahnmaut.logik.DatenInput.laufendeFahrtAktualisieren(autobahnmaut.logik.DatenInput.datenUmwandeln(s));
           } catch (ParseException ex) {
               Logger.getLogger(DatenInput.class.getName()).log(Level.SEVERE, null, ex);
           }
        
       }
    }
}
