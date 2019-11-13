/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Nutzer;
import autobahnmaut.model.Rechnung;
import autobahnmaut.model.Rechnungsfahrten;
import autobahnmaut.model.Rechnungsposition;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

        /*wenn ein Nutzer gefunden wird gib Nutzer zurück
                ansonsten null
         */
        return null;
    }

    public static String getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        String pattern = "MM/dd/yyyy HH:mm:ss";        
        DateFormat df = new SimpleDateFormat(pattern);
        String dateAsString = df.format(cal.getTime());
        return dateAsString;
    }

    public static String getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        String pattern = "MM/dd/yyyy HH:mm:ss";      
        DateFormat df = new SimpleDateFormat(pattern);        
        String dateAsString = df.format(cal.getTime());
        return dateAsString;
    }

    //Erstellt eine Rechnung mit Daten für einen Nutzer für einen Monat
    public static Rechnung rechnungsdaten(int nutzerId, Date monat) {
        Rechnung rechnung = new Rechnung();
        getFirstDateOfMonth(monat);

        ArrayList<Rechnungsposition> rpL = new ArrayList<>();
        ArrayList<Rechnungsfahrten> rfL = new ArrayList<>();
        String query = "Select nutzerid,fahrzeugid, startzeitpunkt,endzeitpunkt, mautbrueckestart, mautbrueckerecent, kennzeichen,kilometer, standort.bezeichnung as Startort, standort2.bezeichnung as Endort from fahrtenabgeschlossen "
                + "inner join fahrzeug ON fahrzeug.id = fahrtenabgeschlossen.fahrzeugid "
                + "inner join nutzer ON nutzer.id = fahrzeug.nutzerid "
                + "inner join mautbruecke ON mautbruecke.id = fahrtenabgeschlossen.mautbrueckestart "
                + "inner join mautbruecke mautbruecke2 ON mautbruecke2.id = fahrtenabgeschlossen.mautbrueckerecent "
                + "inner join standort ON standort.id = mautbruecke.standortid "
                + "inner join standort standort2 ON standort2.id = mautbruecke2.standortid "
                + "\n"
                + "where nutzer.id = " + nutzerId + " and endzeitpunkt  between '" + getFirstDateOfMonth(monat) + "' and '" + getLastDateOfMonth(monat) + "' "
                + " order by fahrzeugid;";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            Rechnungsposition rp = new Rechnungsposition();

            while (rs.next()) {
                if (rp.getKennzeichen() == null) {
                    rp.setKennzeichen(rs.getString("kennzeichen"));
                }
                if (!rp.getKennzeichen().equals(rs.getString("kennzeichen"))) {
                    rp.setRechnungsfahrtenListe(rfL);
                    rpL.add(rp);

                    rp = new Rechnungsposition();
                    rfL.clear();
                    rp.setKennzeichen(rs.getString("kennzeichen"));
                }

                Rechnungsfahrten rf = new Rechnungsfahrten();
                rf.setStartZeitpunkt(rs.getDate("startzeitpunkt"));
                rf.setStartOrt(rs.getString("startort"));
                rf.setEndZeitpunkt(rs.getDate("endzeitpunkt"));
                rf.setEndOrt(rs.getString("endort"));
                rf.setKilometer(rs.getDouble("kilometer"));
                rfL.add(rf);

            }
            rechnung.setNutzer(getNutzerById(nutzerId));
            rechnung.setRechnungspostionsListe(rpL);

            System.out.println("Klappt");
            return rechnung;

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        
        return null;
    }
}
