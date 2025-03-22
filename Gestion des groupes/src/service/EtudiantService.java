/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Etudiant;
import beans.Grpage;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ouahm
 */
public class EtudiantService implements IDao<Etudiant> {

    private Connexion connexion;
    private GrpageService gs;

    public EtudiantService() {
        connexion = Connexion.getInstance();
        gs = new GrpageService();
    }

    @Override
    public boolean create(Etudiant o) {
        String req = "insert into Etudiant (id, nom, prenom, email, groupe_id) values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getGroupe().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        String req = "delete from Etudiant where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Etudiant o) {
        String req = "update Etudiant set nom = ?, prenom = ?, email = ?, groupe_id = ? where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getGroupe().getId());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        String req = "select * from Etudiant where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("email"), gs.findById(rs.getInt("groupe_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    @Override
public List<Etudiant> findAll() {
    List<Etudiant> etudiants = new ArrayList<>();
    String req = "SELECT * FROM Etudiant"; 
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            etudiants.add(new Etudiant(
                rs.getInt("id"), 
                rs.getString("nom"), 
                rs.getString("prenom"), 
                rs.getString("email"), 
                gs.findById(rs.getInt("groupe_id"))
            ));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return etudiants;
}


    public List<Etudiant> findByGrpage(Grpage g) {
        List<Etudiant> etudiants = new ArrayList<>();
        String req = "select * from Etudiant where  groupe_id  = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1,g.getId());
;            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("email"), gs.findById(rs.getInt("groupe_id"))));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etudiants;
    }

 
}
