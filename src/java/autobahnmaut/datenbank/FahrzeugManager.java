/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

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
//    public static boolean registrieren(String kennzeichen, String NutzerId, Integer landId) {
//
//            String query = "select \n"
//                    + "	* \n"
//                    + "from \n"
//                    + "	nutzer\n"
//                    + "where \n"
//                    + "	email = '" + anmeldeemail + "' and \n"
//                    + "	passwort = crypt('" + anmeldepasswort + "',passwort);";
//            try {
//                Statement stm = Datenbank.getStatement();
//                ResultSet rs = stm.executeQuery(query);
//                if (rs.next()) {
//                    //falls ein Nutzer mit den Daten angelegt ist wird null zurückgegeben
//                    return null;
//                } else {
//                    //sonst wird Nutzer mit den Daten angelegt
//                    stm = Datenbank.getStatement();
//                    query = "INSERT INTO nutzer(\n"
//                            + "	email, passwort, rolle, nutzername, strasse, plz, ort, rabatt)\n"
//                            + "	VALUES ('" + anmeldeemail + "',crypt('" + anmeldepasswort
//                            + "',gen_salt('md5')) ,'" + rolle + "','" + name + "','" + strasse
//                            + "','" + plz + "','" + ort + "'," + rabatt + ");";
//
//                    stm.executeUpdate(query);
//
//                    query = "select \n"
//                            + "	* \n"
//                            + "from \n"
//                            + "	nutzer\n"
//                            + "where \n"
//                            + "	email = '" + anmeldeemail + "' and \n"
//                            + "	passwort = crypt('" + anmeldepasswort + "',passwort);";
//
//                    stm = Datenbank.getStatement();
//                    rs = stm.executeQuery(query);
//                    if (rs.next()) {
//                        
//                        //Der angelegte Nutzer wird in einem Nutzerobjekt abgelegt und zurückgegeben
//                        Nutzer n = new Nutzer();
//                        n.setNutzerId(rs.getInt("id"));
//                        n.setName(rs.getString("nutzername"));
//                        n.setEmail(rs.getString("email"));
//                        n.setRolle(rs.getString("rolle"));
//                        n.setStrasse(rs.getString("strasse"));
//                        n.setPlz(rs.getString("plz"));
//                        n.setRabatt(rs.getDouble("rabatt"));
//                        n.setOrt(rs.getString("ort"));
//                        return n;
//                    }
//                }
//            } catch (SQLException sqle) {
//                System.out.println(sqle);
//            }
//
//   
//        return null;
//    }
    public static ArrayList<Fahrzeug> fahrzeuglisteNutzer(int nutzerId) {
        ArrayList<Fahrzeug> fahrzeugListe = new ArrayList<>();

        //String query = "SELECT * FROM fahrzeug WHERE nutzerid = " + nutzerId + ";";

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	fahrzeug\n"
                + "where \n"
                + "	nutzerid = " + nutzerId + ";";

        try {
            Statement stm = Datenbank.getStatement();
            System.out.println(query);
            ResultSet rs = stm.executeQuery(query);
            System.out.println("fahrzeuglisteNutzer called");

            while (rs.next()) {

                Fahrzeug f = new Fahrzeug();
                f.setFahrzeugId(rs.getInt("id"));
                f.setKennzeichen(rs.getString("kennzeichen"));
                f.setPrivileg(rs.getBoolean("privileg"));
                f.setNutzer(autobahnmaut.datenbank.UserManager.getNutzerById(rs.getInt("nutzerid")));
                f.setLand(autobahnmaut.datenbank.FahrzeugManager.getLandById(rs.getInt("landid")));

                fahrzeugListe.add(f);
                
                System.out.println("Fahrzeugliste:" + f.toString());
                
            }return fahrzeugListe;
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

        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }

    
    public static Fahrzeug getFahrzeugByKennzeichenAndLandid(String kennzeichen,int landid) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	fahrzeug\n"
                + "where \n"
                + "	kennzeichen = '" + kennzeichen + "'and landid="+landid +");";
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

        }

        /*wenn ein Land gefunden wurde gib Land zurück
                ansonsten null
         */
        return null;
    }
}
