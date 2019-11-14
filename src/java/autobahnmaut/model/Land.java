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
public class Land {
    private int landId;
    private String bezeichnung;
    private String kurzBezeichnung;

    public int getLandId() {
        return landId;
    }

    @Override
    public String toString() {
        return  bezeichnung ;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getKurzBezeichnung() {
        return kurzBezeichnung;
    }

    public void setKurzBezeichnung(String kurzBezeichnung) {
        this.kurzBezeichnung = kurzBezeichnung;
    }
    
    
}
