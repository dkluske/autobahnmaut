/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.model;

import java.time.*;
import java.util.Date;

/**
 *
 * @author 17wi1188
 */
public class Rechnung {
    private int rechnungId;
    private Date erstellt;
    private Date bezahlt;
    private double summe;
    private Nutzer nutzer;

    public int getRechnungId() {
        return rechnungId;
    }

    public void setRechnungId(int rechnungId) {
        this.rechnungId = rechnungId;
    }

    public Date getErstellt() {
        return erstellt;
    }

    public void setErstellt(Date erstellt) {
        this.erstellt = erstellt;
    }

    public Date getBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(Date bezahlt) {
        this.bezahlt = bezahlt;
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme(double summe) {
        this.summe = summe;
    }

    public Nutzer getNutzer() {
        return nutzer;
    }

    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }
    
    
}
