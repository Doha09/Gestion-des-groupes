/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ouahm
 */
public class Connexion {

    private static Connexion instance = null;
    private Connection cn = null;

    private final String url = "jdbc:mysql://localhost:3306/gestion_groupes";
    private final String login = "root";
    private final String password = "";

    private Connexion() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion réussie à la base de données !");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introuvable : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données : " + ex.getMessage());
        }
    }

    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    public Connection getCn() {
        return cn;
    }
}
