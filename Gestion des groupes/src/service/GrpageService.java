/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public class GrpageService implements IDao<Grpage> {

    private Connexion connexion;

    public GrpageService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Grpage o) {
        String req = "insert into Grpage (id, nom_groupe, niveau, filiere, effectif) values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNomGroupe());
            ps.setString(2, o.getNiveau());
            ps.setString(3, o.getFiliere());
            ps.setInt(4, o.getEffectif());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Grpage o) {
        String req = "delete from Grpage where id = ?";
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
    public boolean update(Grpage o) {
        String req = "update Grpage set nom_groupe = ?, niveau = ?, filiere = ?, effectif = ? where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNomGroupe());
            ps.setString(2, o.getNiveau());
            ps.setString(3, o.getFiliere());
            ps.setInt(4, o.getEffectif());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Grpage findById(int id) {
        String req = "select * from Grpage where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Grpage(rs.getInt("id"), rs.getString("nom_groupe"), rs.getString("niveau"),
                        rs.getString("filiere"), rs.getInt("effectif"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Grpage> findAll() {
        List<Grpage> groupes = new ArrayList<>();
        String req = "select * from Grpage";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                groupes.add(new Grpage(rs.getInt("id"), rs.getString("nom_groupe"), rs.getString("niveau"),
                        rs.getString("filiere"), rs.getInt("effectif")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupes;
    }
}
