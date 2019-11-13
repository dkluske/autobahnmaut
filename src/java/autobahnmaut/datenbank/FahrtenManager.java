/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Abschnitt;
import autobahnmaut.model.FahrtenLaufend;
import autobahnmaut.model.Fahrzeug;
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

    public static FahrtenLaufend getLaufendeFahrt(int fahrzeugId) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	fahrtenlaufend\n"
                + "where \n"
                + "	id = '" + fahrzeugId + "');";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                FahrtenLaufend laufendeFahrt = new FahrtenLaufend();

                laufendeFahrt.setAktuelleZeit(rs.getDate("endzeitpunkt"));
                laufendeFahrt.setFahrtenLaufendId(rs.getInt("id"));
                laufendeFahrt.setFahrzeug(FahrzeugManager.getFahrzeugById(rs.getInt("fahrzeugid")));
                laufendeFahrt.setKilometer(rs.getDouble("kilometer"));
                laufendeFahrt.setMautbrueckeRecent(getMautbrueckeById(rs.getInt("mautbrueckeRecent")));
                laufendeFahrt.setStartZeit(rs.getDate("startzeitpunkt"));
                laufendeFahrt.setMautbrueckeStart(getMautbrueckeById(rs.getInt("mautbrueckestart")));

                return laufendeFahrt;
            }
        } catch (SQLException sqle) {

        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }

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

    public static Abschnitt getAbschnittByIds(int startstandort, int endstandort) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	abschnitt\n"
                + "where \n"
                + "	startstandort = " + startstandort + "and endstandort =" + endstandort + ");";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Abschnitt a = new Abschnitt();

                a.setAbschnittID(rs.getInt("id"));
                a.setDistanz(rs.getDouble("distanz"));
                a.setStartStandort(getStandordById(rs.getInt("startstandort")));
                a.setEndStandort(getStandordById(rs.getInt("endstandort")));

                return a;
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
