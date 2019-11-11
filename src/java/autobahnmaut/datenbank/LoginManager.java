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
public class LoginManager {
    public static Nutzer login(String login, String passwort){        
       
        String query = "select \n" +
                        "	* \n" +
                        "from \n" +
                        "	autobahnmaut.nutzer\n" +
                        "where \n" +
                        "	login = '"+login+"' and \n" +
                        "	passwort = crypt('"+passwort+"',passwort);"; 
        try{
            Statement stm = Datenbank.getStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()){
                Nutzer n = new Nutzer();
                n.setNutzerId(rs.getInt("rolle"));
                n.setName(rs.getString("name"));
                n.setEmail(rs.getString("email") );
                n.setRolle(rs.getString("rolle"));    
                n.setStrasse(rs.getString("strasse"));
                n.setPlz(rs.getString("plz"));
                n.setRabatt(rs.getDouble("rabatt"));     
                
                return n;
            }
        }catch(SQLException sqle){
            
        }     
        
        /*wenn ein kunde gefunden wurde gib Kunden zurück
                ansonsten null
        */
       
        return null;
    }   
}
