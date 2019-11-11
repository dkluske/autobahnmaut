/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.model;

/**
 *
 * @author 17wi1188
 */
public class Mautbruecke {
    private int mautbrueckeID;
    private boolean abfahrt;
    private Standort standort;

    public int getMautbrueckeID() {
        return mautbrueckeID;
    }

    public void setMautbrueckeID(int mautbrueckeID) {
        this.mautbrueckeID = mautbrueckeID;
    }

    public boolean isAbfahrt() {
        return abfahrt;
    }

    public void setAbfahrt(boolean abfahrt) {
        this.abfahrt = abfahrt;
    }

    public Standort getStandort() {
        return standort;
    }

    public void setStandort(Standort standort) {
        this.standort = standort;
    }
    
}
