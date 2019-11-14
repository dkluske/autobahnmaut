/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.model;

import java.util.Date;

/**
 *
 * @author 17wi1188
 */
public class Rechnungsfahrten {
    private Date startZeitpunkt;
    private String startOrt;
    private Date endZeitpunkt;
    private String endOrt;
    private Double kilometer;

    public Date getStartZeitpunkt() {
        return startZeitpunkt;
    }

    public void setStartZeitpunkt(Date startZeitpunkt) {
        this.startZeitpunkt = startZeitpunkt;
    }

    public String getStartOrt() {
        return startOrt;
    }

    public void setStartOrt(String startOrt) {
        this.startOrt = startOrt;
    }

    public Date getEndZeitpunkt() {
        return endZeitpunkt;
    }

    public void setEndZeitpunkt(Date endZeitpunkt) {
        this.endZeitpunkt = endZeitpunkt;
    }

    public String getEndOrt() {
        return endOrt;
    }

    public void setEndOrt(String endOrt) {
        this.endOrt = endOrt;
    }

    public Double getKilometer() {
        return kilometer;
    }

    public void setKilometer(Double kilometer) {
        this.kilometer = kilometer;
    }
    
}
