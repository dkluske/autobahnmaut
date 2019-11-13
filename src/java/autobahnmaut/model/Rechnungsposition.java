/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.model;

import java.util.ArrayList;

/**
 *
 * @author 17wi1188
 */
public class Rechnungsposition {
    private String kennzeichen;
    private ArrayList<Rechnungsfahrten> rechnungsfahrtenListe = new ArrayList<>();

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public ArrayList<Rechnungsfahrten> getRechnungsfahrtenListe() {
        return rechnungsfahrtenListe;
    }

    public void setRechnungsfahrtenListe(ArrayList<Rechnungsfahrten> rechnungsfahrtenListe) {
        this.rechnungsfahrtenListe = rechnungsfahrtenListe;
    }
    
}
