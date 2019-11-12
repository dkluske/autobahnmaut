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
public class Statistikdaten {
    private Land land;
    private double gefahreneKm;

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public double getKm() {
        return gefahreneKm;
    }

    public void setKm(double km) {
        this.gefahreneKm = km;
    }
}
