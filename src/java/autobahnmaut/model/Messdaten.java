/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author 17wi1188
 */
public class Messdaten {

    private Mautbruecke mautbruecke;
    private Date messZeit;
    private Land land;
    private String kennzeichen;
    private Fahrzeug fahrzeug;

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public Mautbruecke getMautbruecke() {
        return mautbruecke;
    }

    public void setMautbruecke(Mautbruecke mautbruecke) {
        this.mautbruecke = mautbruecke;
    }

    public Date getMessZeit() {
        return messZeit;
    }

    public void setMessZeit(Date messZeit) {
        this.messZeit = messZeit;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

}
