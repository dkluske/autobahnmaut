/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Nutzer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 17wi1188
 */
public class UserManager {

    //Es wird ein Nutzer mit den übergebenen Paramtern versucht einzuloggen, bei Erfolg wird der hinterlegte Nutzer zurückgegeben
    public static Nutzer login(String email, String passwort) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	nutzer\n"
                + "where \n"
                + "	email = '" + email + "' and \n"
                + "	passwort = crypt('" + passwort + "',passwort);";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {

                Nutzer n = new Nutzer();
                n.setNutzerId(rs.getInt("id"));
                n.setName(rs.getString("nutzername"));
                n.setEmail(rs.getString("email"));
                n.setRolle(rs.getString("rolle"));
                n.setStrasse(rs.getString("strasse"));
                n.setPlz(rs.getString("plz"));
                n.setRabatt(rs.getDouble("rabatt"));
                n.setOrt(rs.getString("ort"));

                return n;
            }
        } catch (SQLException sqle) {

        }

        /*wenn ein kunde gefunden wurde gib Kunden zurück
                ansonsten null
         */
        return null;
    }

    //Es wird ein nutzer registriert und die Daten aus dem Formular übergeben
    //Der angelegte Nutzer wird zurückgegebn und es wird geprüft ob der neue Nutzer schon vorhanden ist
    public static Nutzer registrieren(String anmeldeemail, String anmeldepasswort, String rolle,
            String name, String strasse, String plz, String ort, double rabatt) {

        if (anmeldeemail != "" && anmeldepasswort != "") {
            String query = "select \n"
                    + "	* \n"
                    + "from \n"
                    + "	nutzer\n"
                    + "where \n"
                    + "	email = '" + anmeldeemail + "' and \n"
                    + "	passwort = crypt('" + anmeldepasswort + "',passwort);";
            try {
                Statement stm = Datenbank.getStatement();
                ResultSet rs = stm.executeQuery(query);
                if (rs.next()) {
                    //falls ein Nutzer mit den Daten angelegt ist wird null zurückgegeben
                    return null;
                } else {
                    //sonst wird Nutzer mit den Daten angelegt
                    stm = Datenbank.getStatement();
                    query = "INSERT INTO nutzer(\n"
                            + "	email, passwort, rolle, nutzername, strasse, plz, ort, rabatt)\n"
                            + "	VALUES ('" + anmeldeemail + "',crypt('" + anmeldepasswort
                            + "',gen_salt('md5')) ,'" + rolle + "','" + name + "','" + strasse
                            + "','" + plz + "','" + ort + "'," + rabatt + ");";

                    stm.executeUpdate(query);

                    query = "select \n"
                            + "	* \n"
                            + "from \n"
                            + "	nutzer\n"
                            + "where \n"
                            + "	email = '" + anmeldeemail + "' and \n"
                            + "	passwort = crypt('" + anmeldepasswort + "',passwort);";

                    stm = Datenbank.getStatement();
                    rs = stm.executeQuery(query);
                    if (rs.next()) {
                        //Der angelegte Nutzer wird in einem Nutzerobjekt abgelegt und zurückgegeben
                        Nutzer n = new Nutzer();
                        n.setNutzerId(rs.getInt("id"));
                        n.setName(rs.getString("nutzername"));
                        n.setEmail(rs.getString("email"));
                        n.setRolle(rs.getString("rolle"));
                        n.setStrasse(rs.getString("strasse"));
                        n.setPlz(rs.getString("plz"));
                        n.setRabatt(rs.getDouble("rabatt"));
                        n.setOrt(rs.getString("ort"));
                        return n;
                    }
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            }
        }

        /*wenn ein kunde gefunden wurde gib Kunden zurück
                ansonsten null
         */
        return null;
    }

    //Den Nutzer zur ID ermitteln
    public static Nutzer getNutzerById(int nutzerId) {

        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	nutzer\n"
                + "where \n"
                + "	nutzerid = '" + nutzerId + "');";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Nutzer n = new Nutzer();
                n.setNutzerId(rs.getInt("nutzerid"));
                n.setName(rs.getString("name"));
                n.setEmail(rs.getString("email"));
                n.setRolle(rs.getString("rolle"));
                n.setStrasse(rs.getString("strasse"));
                n.setPlz(rs.getString("plz"));
                n.setRabatt(rs.getDouble("rabatt"));

                return n;
            }
        } catch (SQLException sqle) {

        }

        /*wenn ein kunde gefunden wurde gib Kunden zurück
                ansonsten null
         */
        return null;
    }
}
