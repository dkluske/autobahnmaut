/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Land;
import autobahnmaut.model.Mautbruecke;
import autobahnmaut.model.Standort;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 17wi1188
 */
public class FahrtenManager {
    
    
    public static Mautbruecke getMautbrueckeById(int mautbrueckeId) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	mautbruecke\n"
                + "where \n"
                + "	id = '" + mautbrueckeId + "');";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Mautbruecke m = new Mautbruecke();
                
                m.setMautbrueckeID(rs.getInt("id"));
                m.setAbfahrt(rs.getBoolean("abfahrt"));
                m.setStandort(getStandordById(rs.getInt("standortid")));

                return m;
            }
        } catch (SQLException sqle) {

        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }
    
    public static Standort getStandordById(int standordId) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	standort\n"
                + "where \n"
                + "	id = '" + standordId + "');";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Standort s = new Standort();
                
                s.setStandortID(rs.getInt("id"));
                s.setBezeichnung(rs.getString("bezeichnung"));                

                return s;
            }
        } catch (SQLException sqle) {

        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }
}
