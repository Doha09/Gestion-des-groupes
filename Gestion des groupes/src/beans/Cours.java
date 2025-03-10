package beans;

public class Cours {
    private int id; 
    private String intitule; 
    private String professeur; 
    private Groupe groupe; 

    public Cours() {
    }

    public Cours(int id, String intitule, String professeur, Groupe groupe) {
        this.id = id;
        this.intitule = intitule;
        this.professeur = professeur;
        this.groupe = groupe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", professeur='" + professeur + '\'' +
                ", groupe=" + groupe + 
                '}';
    }
}