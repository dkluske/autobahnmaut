/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.model;

import java.time.LocalDateTime;

/**
 *
 * @author 17wi1188
 */
public class Messdaten {
    
    private Mautbruecke mautbruecke;
    private LocalDateTime messZeit;    
    private String landBezeichnung;
    private String kennzeichen;

    public Mautbruecke getMautbruecke() {
        return mautbruecke;
    }

    public void setMautbruecke(Mautbruecke mautbruecke) {
        this.mautbruecke = mautbruecke;
    }

    public LocalDateTime getMessZeit() {
        return messZeit;
    }

    public void setMessZeit(LocalDateTime messZeit) {
        this.messZeit = messZeit;
    }

    public String getLandBezeichnung() {
        return landBezeichnung;
    }

    public void setLandBezeichnung(String landBezeichnung) {
        this.landBezeichnung = landBezeichnung;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }
    
    

    

    
}
