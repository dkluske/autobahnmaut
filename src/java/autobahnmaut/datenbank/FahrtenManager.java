/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Abschnitt;
import autobahnmaut.model.FahrtenAbgeschlossen;
import autobahnmaut.model.FahrtenLaufend;
import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Land;

import autobahnmaut.model.Mautbruecke;
import autobahnmaut.model.Nutzer;
import autobahnmaut.model.Standort;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                + "	fahrzeugid = " + fahrzeugId + ";";
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

    public static ArrayList<FahrtenAbgeschlossen> getFalschfahrten() {
        ArrayList<FahrtenAbgeschlossen> flaschfahrtenListe = new ArrayList<>();
        String query = "Select* from fahrtenabgeschlossen inner join "
                + "mautbruecke ON mautbruecke.id = fahrtenabgeschlossen.mautbrueckestart"
                + " where abfahrt =false;";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                FahrtenAbgeschlossen abgeschlosseneFahrt = new FahrtenAbgeschlossen();

                abgeschlosseneFahrt.setEndZeit(rs.getDate("endzeitpunkt"));
                abgeschlosseneFahrt.setFahrtenAbgeschlossenId(rs.getInt("id"));
                abgeschlosseneFahrt.setFahrzeug(FahrzeugManager.getFahrzeugById(rs.getInt("fahrzeugid")));
                abgeschlosseneFahrt.setKilometer(rs.getDouble("kilometer"));
                abgeschlosseneFahrt.setMautbrueckeRecent(getMautbrueckeById(rs.getInt("mautbrueckeRecent")));
                abgeschlosseneFahrt.setStartZeit(rs.getDate("startzeitpunkt"));
                abgeschlosseneFahrt.setMautbrueckeStart(getMautbrueckeById(rs.getInt("mautbrueckestart")));
                flaschfahrtenListe.add(abgeschlosseneFahrt);
            }
            return flaschfahrtenListe;
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
                + "	id = " + mautbrueckeId + ";";
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
                + "	startstandort = " + startstandort + "and endstandort =" + endstandort + ";";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Abschnitt a = new Abschnitt();

                a.setAbschnittID(rs.getInt("id"));
                a.setDistanz(rs.getDouble("distanz"));
                a.setStartStandort(getStandordById(rs.getInt("startstandort")));
                a.setEndStandort(getStandordById(rs.getInt("endstandort")));
                System.out.println("Klappt");
                return a;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
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
                + "	id = " + standordId + ";";
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

    public static boolean createNewLaufendeFahrt(FahrtenLaufend fahrtenlaufend) {

        String query = "Insert into fahrtenlaufend (fahrzeugid, MautbrueckeStart, Startzeitpunkt,"
                + " MautbrueckeRecent,Endzeitpunkt,Kilometer) values ( "
                + fahrtenlaufend.getFahrzeug().getFahrzeugId() + ", "
                + fahrtenlaufend.getMautbrueckeStart().getMautbrueckeID() + ", '"
                + fahrtenlaufend.getStartZeit() + "', "
                + fahrtenlaufend.getMautbrueckeRecent().getMautbrueckeID() + ", '"
                + fahrtenlaufend.getAktuelleZeit() + "', "
                + fahrtenlaufend.getKilometer() + "); ";
        try {
            Statement stm = Datenbank.getStatement();
            System.out.println(query);
            stm.executeUpdate(query);
            return true;

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return false;
    }

    public static boolean updateLaufendeFahrt(FahrtenLaufend fahrtenlaufend) {

        String query = "UPDATE fahrtenlaufend SET MautbrueckeRecent = "
                + fahrtenlaufend.getMautbrueckeRecent().getMautbrueckeID() + ", Endzeitpunkt=   '"
                + fahrtenlaufend.getAktuelleZeit() + "', "
                + "Kilometer=" + fahrtenlaufend.getKilometer()
                + "WHERE fahrtenlaufend.id = " + fahrtenlaufend.getFahrtenLaufendId() + ";";

        try {
            Statement stm = Datenbank.getStatement();

            stm.executeUpdate(query);
            return true;

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return false;
    }

    public static boolean updateLaufendeFahrtToAbgeschlossen(FahrtenLaufend fahrtenlaufend) {

        String query = "Insert into fahrtenabgeschlossen (fahrzeugid, MautbrueckeStart, Startzeitpunkt,"
                + " MautbrueckeRecent,Endzeitpunkt,Kilometer) values ( "
                + fahrtenlaufend.getFahrzeug().getFahrzeugId() + ", "
                + fahrtenlaufend.getMautbrueckeStart().getMautbrueckeID() + ", '"
                + fahrtenlaufend.getStartZeit() + "', "
                + fahrtenlaufend.getMautbrueckeRecent().getMautbrueckeID() + ", '"
                + fahrtenlaufend.getAktuelleZeit() + "', "
                + fahrtenlaufend.getKilometer() + "); ";

        try {
            Statement stm = Datenbank.getStatement();

            stm.executeUpdate(query);

            query = "DELETE FROM fahrtenlaufend WHERE fahrtenlaufend.id = "
                    + fahrtenlaufend.getFahrtenLaufendId() + ";";

            stm.executeUpdate(query);
            return true;

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return false;
    }

    public static ArrayList<String> getSimulatorDaten() {
        ArrayList<String> simulatorDaten = new ArrayList<>();
        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	daten\n"
                + ";";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {

                simulatorDaten.add(rs.getString("line"));

            }
            return simulatorDaten;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein kunde gefunden wurde gib Kunden zurück
                ansonsten null
         */
        return null;
    }

    public static boolean deleteFahrten() {

        String query = "delete from fahrtenabgeschlossen;";

        try {
            Statement stm = Datenbank.getStatement();

            stm.executeUpdate(query);
            query = "delete from fahrtenlaufend;";
            stm.executeUpdate(query);
            return true;

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return false;
    }

//    public static void putFahrt(int standordId) {
//
//        String query = "insert "
//                + "	* \n"
//                + "from \n"
//                + "	fahrtenlaufend\n"
//                + "where \n"
//                + "	id = '" + fahrzeugId + "');";
//        try {
//            Statement stm = Datenbank.getStatement();
//            ResultSet rs = stm.executeQuery(query);
//            if (rs.next()) {
//                FahrtenLaufend laufendeFahrt = new FahrtenLaufend();
//
//                laufendeFahrt.setAktuelleZeit(rs.getDate("endzeitpunkt"));
//                laufendeFahrt.setFahrtenLaufendId(rs.getInt("id"));
//                laufendeFahrt.setFahrzeug(FahrzeugManager.getFahrzeugById(rs.getInt("fahrzeugid")));
//                laufendeFahrt.setKilometer(rs.getDouble("kilometer"));
//                laufendeFahrt.setMautbrueckeRecent(getMautbrueckeById(rs.getInt("mautbrueckeRecent")));
//                laufendeFahrt.setStartZeit(rs.getDate("startzeitpunkt"));
//                laufendeFahrt.setMautbrueckeStart(getMautbrueckeById(rs.getInt("mautbrueckestart")));
//
//                return laufendeFahrt;
//            }
//        } catch (SQLException sqle) {
//
//        }
//
//        /*wenn ein Land gefunden wurde gib Land zurück
//                ansonsten null
//         */
//        return null;
//}
}
