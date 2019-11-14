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
import java.util.Date;

/**
 *
 * @author 17wi1188
 */
public class DatenInput {

    private static Messdaten datenUmwandeln(String simulatordaten) throws ParseException {
        Messdaten messdaten = new Messdaten();
        String[] messdatenArray = simulatordaten.split(";");

        messdaten.setMautbruecke(FahrtenManager.getMautbrueckeById(Integer.parseInt(messdatenArray[0])));
        Date messzeit = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(messdatenArray[1]);
        messdaten.setMessZeit(messzeit);
        messdaten.setLand(FahrzeugManager.getLandById(Integer.parseInt(messdatenArray[2])));
        messdaten.setKennzeichen(messdatenArray[3]);

        messdaten.setFahrzeug(FahrzeugManager.getFahrzeugByKennzeichenAndLandid(messdaten.getKennzeichen(), messdaten.getLand().getLandId()));

        return messdaten;
    }

    private static FahrtenLaufend laufendeFahrtAktualisieren(Messdaten messdaten) {
        FahrtenLaufend aktuelleFahrt = FahrtenManager.getLaufendeFahrt(messdaten.getFahrzeug().getFahrzeugId());

        if (aktuelleFahrt != null) {

            double abstand = FahrtenManager.getAbschnittByIds(aktuelleFahrt.getMautbrueckeRecent().
                    getStandort().getStandortID(), messdaten.getMautbruecke().getStandort().getStandortID()).getDistanz();
            aktuelleFahrt.setKilometer(aktuelleFahrt.getKilometer()+abstand);
            aktuelleFahrt.setMautbrueckeRecent(messdaten.getMautbruecke());
            aktuelleFahrt.setAktuelleZeit(messdaten.getMessZeit());
            
        }else{
            aktuelleFahrt.setAktuelleZeit(messdaten.getMessZeit());
            aktuelleFahrt.setFahrzeug(messdaten.getFahrzeug());
            aktuelleFahrt.setKilometer(0);
            aktuelleFahrt.setMautbrueckeRecent(messdaten.getMautbruecke());
            aktuelleFahrt.setMautbrueckeStart(messdaten.getMautbruecke());
            aktuelleFahrt.setStartZeit(messdaten.getMessZeit());
            
        }
        return aktuelleFahrt;
    }
}
