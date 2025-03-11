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
public class Grpage {

    private int id;
    private String nomGroupe;
    private String niveau;
    private String filiere;
    private int effectif;

    public Grpage(int id, String nomGroupe, String niveau, String filiere, int effectif) {
        this.id = id;
        this.nomGroupe = nomGroupe;
        this.niveau = niveau;
        this.filiere = filiere;
        this.effectif = effectif;
    }

    public Grpage(String nomGroupe, String niveau, String filiere, int effectif) {
        this.nomGroupe = nomGroupe;
        this.niveau = niveau;
        this.filiere = filiere;
        this.effectif = effectif;
    }

    public int getId() {
        return id;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getFiliere() {
        return filiere;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

}
