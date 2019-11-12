package autobahnmaut.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {

    private static Connection connection = null;

    
    public static Connection getConnection() {

        if (Datenbank.connection != null) {
            return Datenbank.connection;
        } else {
            //Neue Verbindung aufbauen und zurückgeben
            String dbURL = "jdbc:postgresql://localhost:5432/autobahnmaut";
            try {
                Class.forName("org.postgresql.Driver");
                //Nutzer definieren
                Datenbank.connection = DriverManager.getConnection(dbURL, "netbeans", "netbeans");
                return Datenbank.connection;
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } catch (ClassNotFoundException cnf) {
                System.out.println("Datenbanktreiber nicht gefunden.");
            }
        }
        
        return null;
    }

    public static Statement getStatement() {

        Connection con = Datenbank.getConnection();
        if (con != null) {
            try {
                Statement s = con.createStatement();
                return s;
            } catch (SQLException sqle) {
                System.out.println(sqle);
            }
        }
        return null;
    }

}
