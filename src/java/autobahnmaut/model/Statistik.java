package autobahnmaut.model;

import java.util.ArrayList;

public class Statistik {

    private ArrayList<Statistikdaten> statistikListe = new ArrayList<>();

    public ArrayList<Statistikdaten> getStatistikListe() {
        return statistikListe;
    }

    public void setStatistikListe(ArrayList<Statistikdaten> statistikListe) {
        this.statistikListe = statistikListe;
    }
    
    public void addStatistikListe(Statistikdaten statistikdaten) {
        this.statistikListe.add(statistikdaten);
    }

}
