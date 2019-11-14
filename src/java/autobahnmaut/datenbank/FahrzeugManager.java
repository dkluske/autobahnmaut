
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.FahrtenLaufend;
import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Land;
import autobahnmaut.model.Nutzer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 17wi1188
 */
public class FahrzeugManager {

    public static ArrayList<Fahrzeug> fahrzeuglisteNutzer(int nutzerId) {
        ArrayList<Fahrzeug> fahrzeugListe = new ArrayList<>();
        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	fahrzeug\n"
                + "where \n"
                + "	nutzerid = " + nutzerId + ";";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {

                Fahrzeug f = new Fahrzeug();
                f.setFahrzeugId(rs.getInt("id"));
                f.setKennzeichen(rs.getString("kennzeichen"));
                f.setPrivileg(rs.getBoolean("privileg"));
                f.setNutzer(autobahnmaut.datenbank.UserManager.getNutzerById(rs.getInt("nutzerid")));
                f.setLand(autobahnmaut.datenbank.FahrzeugManager.getLandById(rs.getInt("landid")));

                fahrzeugListe.add(f);

            }
            return fahrzeugListe;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein kunde gefunden wurde gib Kunden zurück
                ansonsten null
         */
        return null;
    }

    public static Land getLandById(int landId) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	land\n"
                + "where \n"
                + "	id = " + landId + ";";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Land l = new Land();
                l.setLandId(rs.getInt("id"));
                l.setBezeichnung(rs.getString("bezeichnung"));
                l.setKurzBezeichnung(rs.getString("kurzbezeichnung"));

                return l;
            }
        } catch (SQLException sqle) {

        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }

    public static Fahrzeug getFahrzeugById(int fahrzeugid) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	fahrzeug\n"
                + "where \n"
                + "	id = " + fahrzeugid + ";";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Fahrzeug f = new Fahrzeug();

                f.setFahrzeugId(rs.getInt("id"));
                f.setKennzeichen(rs.getString("kennzeichen"));
                f.setLand(FahrzeugManager.getLandById(rs.getInt("landid")));
                f.setNutzer(UserManager.getNutzerById(rs.getInt("nutzerid")));
                f.setPrivileg(rs.getBoolean("privileg"));

                return f;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }

    public static Fahrzeug getFahrzeugByKennzeichenAndLandid(String kennzeichen, int landid) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	fahrzeug\n"
                + "where \n"
                + "	kennzeichen = '" + kennzeichen + "'and landid=" + landid + ";";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Fahrzeug f = new Fahrzeug();

                f.setFahrzeugId(rs.getInt("id"));
                f.setKennzeichen(rs.getString("kennzeichen"));
                f.setLand(FahrzeugManager.getLandById(rs.getInt("landid")));
                f.setNutzer(UserManager.getNutzerById(rs.getInt("nutzerid")));
                f.setPrivileg(rs.getBoolean("privileg"));

                return f;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }

    public static ArrayList<Fahrzeug> getFahrzeugePolizei() {
        ArrayList<Fahrzeug> fahrzeugListe = new ArrayList<>();
        String query = "select * from fahrzeug \n"
                + "inner join nutzer on fahrzeug.nutzerid = Nutzer.id\n"
                + "where nutzer.rolle='Polizei';";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Fahrzeug f = new Fahrzeug();

                f.setFahrzeugId(rs.getInt("id"));
                f.setKennzeichen(rs.getString("kennzeichen"));
                f.setLand(FahrzeugManager.getLandById(rs.getInt("landid")));
                f.setNutzer(UserManager.getNutzerById(rs.getInt("nutzerid")));
                f.setPrivileg(rs.getBoolean("privileg"));
                fahrzeugListe.add(f);
                
            }return fahrzeugListe;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }
    //muss geändert werden
    public static boolean updateFahrzeug(Fahrzeug fahrzeug) {        
        String query = "UPDATE fahrzeug SET  kennzeichen=   '" 
                + fahrzeug.getKennzeichen() + "',  landid="
                + fahrzeug.getLand().getLandId()+ ",  nutzerid="
                + fahrzeug.getNutzer().getNutzerId()               
                + " WHERE fahrzeug.id = " + fahrzeug.getFahrzeugId() + ";";
        try {
            Statement stm = Datenbank.getStatement();
            System.out.println(query);
            ResultSet rs = stm.executeQuery(query);
            return true;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return false;
    }
    
    public static boolean createFahrzeug(Fahrzeug fahrzeug) {

        String query = "INSERT INTO fahrzeug (kennzeichen, landid, nutzerid, privileg) VALUES('"
                + fahrzeug.getKennzeichen()+ "', "
                + fahrzeug.getLand().getLandId()+ ", "
                + fahrzeug.getNutzer().getNutzerId() + ", "               
                + fahrzeug.isPrivileg() + "); ";       
        
        
        try {
            Statement stm = Datenbank.getStatement();
            //System.out.println(query);
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
}

