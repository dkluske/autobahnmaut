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
public class FahrtenAbgeschlossen {
    private int fahrtenAbgeschlossenId;
    private double kilometer;
    private Date startZeit;
    private Date endZeit;
    private Mautbruecke mautbrueckeStart;
    private Mautbruecke mautbrueckeRecent;
    private Fahrzeug fahrzeug;

    public Date getStartZeit() {
        return startZeit;
    }

    public void setStartZeit(Date startZeit) {
        this.startZeit = startZeit;
    }

    public Date getEndZeit() {
        return endZeit;
    }

    public void setEndZeit(Date endZeit) {
        this.endZeit = endZeit;
    }

     public int getFahrtenAbgeschlossenId() {
        return fahrtenAbgeschlossenId;
    }

    public void setFahrtenAbgeschlossenId(int fahrtenAbgeschlossenId) {
        this.fahrtenAbgeschlossenId = fahrtenAbgeschlossenId;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public Mautbruecke getMautbrueckeStart() {
        return mautbrueckeStart;
    }

    public void setMautbrueckeStart(Mautbruecke mautbrueckeStart) {
        this.mautbrueckeStart = mautbrueckeStart;
    }

    public Mautbruecke getMautbrueckeRecent() {
        return mautbrueckeRecent;
    }

    public void setMautbrueckeRecent(Mautbruecke mautbrueckeRecent) {
        this.mautbrueckeRecent = mautbrueckeRecent;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
    
    
}
