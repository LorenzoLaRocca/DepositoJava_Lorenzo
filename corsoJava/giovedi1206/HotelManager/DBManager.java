package giovedi1206.HotelManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/local";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Sostituisci con la tua password

    public static Connection getConnection() throws SQLException {
        try {
            // Carica esplicitamente il driver JDBC di MySQL 
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL non trovato nel classpath!");
            e.printStackTrace();   
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}