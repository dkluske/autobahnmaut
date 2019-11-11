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
public class Abschnitt {

    private int abschnittID;
    private double distanz;
    private Standort startStandort;
    private Standort endStandort;

    public int getAbschnittID() {
        return abschnittID;
    }

    public void setAbschnittID(int abschnittID) {
        this.abschnittID = abschnittID;
    }

    public double getDistanz() {
        return distanz;
    }

    public void setDistanz(double distanz) {
        this.distanz = distanz;
    }

    public Standort getStartStandort() {
        return startStandort;
    }

    public void setStartStandort(Standort startStandort) {
        this.startStandort = startStandort;
    }

    public Standort getEndStandort() {
        return endStandort;
    }

    public void setEndStandort(Standort endStandort) {
        this.endStandort = endStandort;
    }

}
