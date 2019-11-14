/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut;

import autobahnmaut.datenbank.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class SampleQuery {

    public static void main(String[] args) {

        autobahnmaut.datenbank.Datenbank.getConnection();
        Date monat = Calendar.getInstance().getTime();
        //autobahnmaut.datenbank.UserManager.rechnungsdaten(3, monat);
        autobahnmaut.datenbank.StatistikManager.getStatistikdaten();

    }
}
