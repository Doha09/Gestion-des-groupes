/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Utilisateur;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author ouahm
 */


public class UtilisateurService {

    private Connexion connexion;

    public UtilisateurService() {
        connexion = Connexion.getInstance();
    }

    // Ajouter un utilisateur avec mot de passe haché
    public boolean create(Utilisateur u) {
        String sql = "INSERT INTO utilisateur (login, password, role) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(sql)) {
            ps.setString(1, u.getLogin());
            ps.setString(2, BCrypt.hashpw(u.getPassword(), BCrypt.gensalt())); // Hachage sécurisé
            ps.setString(3, u.getRole()); 
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur create Utilisateur : " + ex.getMessage());
        }
        return false;
    }

    // Vérifier si un utilisateur existe (authentification)
    public Utilisateur authenticate(String login, String password) {
    String sql = "SELECT * FROM utilisateur WHERE login = ?";

    try (PreparedStatement ps = connexion.getCn().prepareStatement(sql)) {
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String hashedPassword = rs.getString("password");

            // Debugging: Afficher le mot de passe entré et haché
            System.out.println("Mot de passe entré : " + password);
            System.out.println("Mot de passe haché en BD : " + hashedPassword);

            if (BCrypt.checkpw(password, hashedPassword)) {
                System.out.println("Mot de passe correct !");
                return new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("login"),
                    hashedPassword,
                    rs.getString("role")
                );
            } else {
                System.out.println("Mot de passe incorrect !");
            }
        } else {
            System.out.println("Utilisateur non trouvé !");
        }
    } catch (SQLException ex) {
        System.out.println("Erreur authenticate Utilisateur : " + ex.getMessage());
    }
    return null;
}


    // Trouver un utilisateur par login
    public Utilisateur findByLogin(String login) {
        String sql = "SELECT * FROM utilisateur WHERE login = ?";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(sql)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findByLogin : " + ex.getMessage());
        }
        return null;
    }

    // Récupérer tous les utilisateurs
    public List<Utilisateur> findAll() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                utilisateurs.add(new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("role")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll Utilisateur : " + ex.getMessage());
        }
        return utilisateurs;
    }

    // Supprimer un utilisateur
    public boolean delete(String login) {
        String sql = "DELETE FROM utilisateur WHERE login = ?";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(sql)) {
            ps.setString(1, login);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Erreur delete Utilisateur : " + ex.getMessage());
        }
        return false;
    }

    // Modifier le mot de passe d'un utilisateur
    public boolean updatePassword(String login, String newPassword) {
        String sql = "UPDATE utilisateur SET password = ? WHERE login = ?";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(sql)) {
            ps.setString(1, BCrypt.hashpw(newPassword, BCrypt.gensalt())); // Hachage sécurisé
            ps.setString(2, login);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Erreur updatePassword Utilisateur : " + ex.getMessage());
        }
        return false;
    }

    // Ajout d’un utilisateur par défaut si la table est vide
    public void addDefaultUsers() {
        if (findAll().isEmpty()) {
            create(new Utilisateur("doha", "2025", "ADMIN"));
            create(new Utilisateur("professeur1", "prof123", "PROFESSEUR"));
            create(new Utilisateur("etudiant1", "etu123", "ETUDIANT"));
            System.out.println("Utilisateurs par défaut ajoutés !");
        }
    }
}


