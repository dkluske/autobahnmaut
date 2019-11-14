/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.datenbank;

import autobahnmaut.model.Messdaten;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andi
 */
public class MessdatenManager{
            
    
//    public static Messdaten getMessdatenById(Integer id){
//        /* 
//        Top 10 der Länder mit den meisten KM
//        
//         */
//        //Statement anpassen
//        String query = "select *\n"
//                + "	* \n"
//                + "from \n"
//                + "	messdaten \n"
//                + "where \n"
//                + "	id = '" + id + "');";
//        try {
//            Statement stm = Datenbank.getStatement();
//            ResultSet rs = stm.executeQuery(query);
//            while (rs.next()) {
//                Messdaten md = new Messdaten();
//                md.setFahrzeug(fahrzeug);
//                md.setKennzeichen(query);
//                md.setLand("land_id");
//                md.setMautbruecke("mautbruecke_id");
//                md.setMessZeit("messzeit");
//            }return md;
//        } catch (SQLException sqle) {
//
//        }
//        
//        return null;
//    }
}
