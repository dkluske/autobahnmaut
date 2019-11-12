/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.logik;

import autobahnmaut.datenbank.FahrtenManager;
import autobahnmaut.model.FahrtenLaufend;
import autobahnmaut.model.Messdaten;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author 17wi1188
 */
public class DatenInput {
    
    private static Messdaten datenUmwandeln(String simulatordaten) throws ParseException{
        Messdaten messdaten= new Messdaten();
        String [] messdatenArray = simulatordaten.split(";");
        
        
        messdaten.setKennzeichen(messdatenArray[0]);
        messdaten.setLandBezeichnung(messdatenArray[1]);
        messdaten.setMautbruecke(FahrtenManager.getMautbrueckeById(Integer.parseInt(messdatenArray[2])));
        Date messzeit=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(messdatenArray[3]);
        messdaten.setMessZeit(messzeit);
        
        return messdaten;
    }
    
    private static FahrtenLaufend laufendeFahrtAnlegen(){
        FahrtenLaufend aktuelleFahrt = new FahrtenLaufend();
        return aktuelleFahrt;
    }
}
