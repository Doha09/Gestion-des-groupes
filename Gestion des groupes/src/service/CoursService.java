/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Cours;
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
public class CoursService implements IDao<Cours> {

    private Connexion connexion;
    private GrpageService gs;

    public CoursService() {
        connexion = Connexion.getInstance();
        gs = new GrpageService();
    }

    @Override
    public boolean create(Cours o) {
        String req = "insert into Cours (id, intitule, professeur, groupe_id) values (null, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setString(2, o.getProfesseur());
            ps.setInt(3, o.getGroupe().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Cours o) {
        String req = "delete from Cours where id = ?";
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
    public boolean update(Cours o) {
        String req = "update Cours set intitule = ?, professeur = ?, groupe_id = ? where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setString(2, o.getProfesseur());
            ps.setInt(3, o.getGroupe().getId());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
public List<Cours> findByGroupeId(int groupeId) {
    List<Cours> cours = new ArrayList<>();
    String req = "SELECT * FROM Cours WHERE groupe_id = ?";
    
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, groupeId);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            cours.add(new Cours(
                rs.getInt("id"),
                rs.getString("intitule"),
                rs.getString("professeur"),
                gs.findById(rs.getInt("groupe_id"))
            ));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
    return cours;
}
    @Override
    public Cours findById(int id) {
        String req = "select * from Cours where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cours(rs.getInt("id"), rs.getString("intitule"), rs.getString("professeur"),
                        gs.findById(rs.getInt("groupe_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Cours> findAll() {
        List<Cours> cours = new ArrayList<>();
        String req = "select * from Cours";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cours.add(new Cours(rs.getInt("id"), rs.getString("intitule"), rs.getString("professeur"),
                        gs.findById(rs.getInt("groupe_id"))));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cours;
    }

}
