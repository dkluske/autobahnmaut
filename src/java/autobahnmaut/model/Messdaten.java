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
public class Messdaten {
    
    private Mautbruecke mautbruecke;
    private Date messZeit;    
    private String landBezeichnung;
    private String kennzeichen;

    public Mautbruecke getMautbruecke() {
        return mautbruecke;
    }

    public void setMautbruecke(Mautbruecke mautbruecke) {
        this.mautbruecke = mautbruecke;
    }

    public Date getMessZeit() {
        return messZeit;
    }

    public void setMessZeit(Date messZeit) {
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
