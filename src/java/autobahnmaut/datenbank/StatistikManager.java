/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Nutzer;
import autobahnmaut.model.Statistik;
import autobahnmaut.model.Statistikdaten;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author 17wi1188
 */
public class StatistikManager {

    public static Statistik getStatistikdaten() {
        Statistik statistik = new Statistik();

        /* 
        Top 10 der Länder mit den meisten KM
        
         */
        //Statement anpassen
        String query = "Select "
                + "sum(fa.kilometer) as kilometer, "
                + "fz.landid as land "
                + "from fahrtenabgeschlossen fa   "
                + "join fahrzeug fz ON fz.id = fa.fahrzeugid  "
                + "where fz.landid > 1 "
                + "group by fz.landid "
                + "order by kilometer desc "
                + "limit 10";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Statistikdaten statistikdaten = new Statistikdaten();
                statistikdaten.setKm(rs.getDouble("kilometer"));
                statistikdaten.setLand(autobahnmaut.datenbank.FahrzeugManager.getLandById(rs.getInt("land")));
                statistik.addStatistikListe(statistikdaten);
                System.out.println(statistikdaten.getKm());
                System.out.println(statistikdaten.getLand().getBezeichnung());
             
             
            }
            System.out.println("Klappt");
            return statistik;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return null;
    }

}
