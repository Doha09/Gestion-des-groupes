package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static DBConnection instance = null;
    private Connection cn = null;

    private final String url = "jdbc:mysql://localhost:3306/grpage_db"; 
    private final String login = "root"; 
    private final String password = ""; 

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion à la base de données réussie !");
        } catch (ClassNotFoundException ex) {
            System.err.println("Erreur : Pilote JDBC introuvable.");
        } catch (SQLException ex) {
            System.err.println("Erreur SQL : " + ex.getMessage());
        }
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

 
    public Connection getConnection() {
        return cn;
    }

  
    public void closeConnection() {
        if (cn != null) {
            try {
                cn.close();
                System.out.println("Connexion à la base de données fermée.");
            } catch (SQLException ex) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + ex.getMessage());
            }
        }
    }
}