/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Fahrzeug;
import autobahnmaut.model.Land;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andi
 */
public class LandManager {
    public static Land getLandById(int landId) {    
        String query = "select \n"
                + "	* \n"
                + "from \n"
                + "	fahrzeug\n"
                + "where \n"
                + "	id = '" + landId + "');";
        try {
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                Land f = new Land();

                f.setLandId(rs.getInt("id"));
                f.setBezeichnung(rs.getString("bezeichnung"));
                f.setKurzBezeichnung(rs.getString("kurzbezeichnung"));

                return f;
            }
        } catch (SQLException sqle) {

        }
        return null;
    }
}

