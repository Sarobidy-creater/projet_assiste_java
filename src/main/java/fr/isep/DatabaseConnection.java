package fr.isep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL      = "jdbc:mysql://localhost:3306/aeroportcontrol";
    private static final String USER     = "root";
    private static final String PASSWORD = "root";

    private static Connection instance = null;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (instance == null) {
            try {
                instance = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion BDD reussie.");
            } catch (SQLException e) {
                System.out.println("Erreur connexion BDD : " + e.getMessage());
            }
        }
        return instance;
    }

    public static void fermer() {
        try {
            if (instance != null && !instance.isClosed()) {
                instance.close();
                instance = null;
                System.out.println("Connexion BDD fermee.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur fermeture BDD : " + e.getMessage());
        }
    }
}

