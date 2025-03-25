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
public class Cours {

    private int id;
    private String intitule;
    private String professeur;
    private Grpage groupe;

    public Cours(int id, String intitule, String professeur, Grpage groupe) {
        this.id = id;
        this.intitule = intitule;
        this.professeur = professeur;
        this.groupe = groupe;
    }

    public Cours(String intitule, String professeur, Grpage groupe) {
        this.intitule = intitule;
        this.professeur = professeur;
        this.groupe = groupe;
    }

    public int getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getProfesseur() {
        return professeur;
    }

    public Grpage getGroupe() {
        return groupe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public void setGroupe(Grpage groupe) {
        this.groupe = groupe;
    }

}
