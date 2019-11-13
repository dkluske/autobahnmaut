/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autobahnmaut;


import autobahnmaut.datenbank.*;
import java.sql.ResultSet;
import java.sql.Statement;


public class SampleQuery {
    
    public static void main (String[] args){
        
        autobahnmaut.datenbank.Datenbank.getConnection();
                     
        autobahnmaut.datenbank.UserManager.rechnungsdaten(3);
    }
           
    
}
