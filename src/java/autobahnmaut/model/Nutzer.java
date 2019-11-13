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
public class Nutzer {

    private int nutzerId;
    private String name;
    private String rolle;
    private String email;
    private String strasse;
    private String plz;
    private String ort;
    private double rabatt = 1;
    private ArrayList<Fahrzeug> fahrzeugListe = new ArrayList<>();

    public ArrayList<Fahrzeug> getFahrzeugListe() {
        return fahrzeugListe;
    }

    public void setFahrzeugListe(ArrayList<Fahrzeug> fahrzeugListe) {
       this.fahrzeugListe = autobahnmaut.datenbank.FahrzeugManager.fahrzeuglisteNutzer(this.nutzerId);         
    }
    @Override
    public String toString() {
        return "Nutzer{" + "name=" + name + ", rolle=" + rolle + ", email=" + email + ", strasse=" + strasse + ", plz=" + plz + ", rabatt=" + rabatt + '}';
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getNutzerId() {
        return nutzerId;
    }

    public void setNutzerId(int nutzerId) {
        this.nutzerId = nutzerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public double getRabatt() {
        return rabatt;
    }

    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }

}
