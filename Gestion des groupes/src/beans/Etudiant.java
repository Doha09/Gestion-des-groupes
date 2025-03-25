/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author ouahm
 */
public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Grpage groupe;

    public Etudiant(int id, String nom, String prenom, String email, Grpage groupe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.groupe = groupe;
    }

    public Etudiant(String nom, String prenom, String email, Grpage groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.groupe = groupe;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Grpage getGroupe() {
        return groupe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroupe(Grpage groupe) {
        this.groupe = groupe;
    }

}
