package beans;

public class Groupe {
    private int id; 
    private String nomGroupe; 
    private String niveau; 
    private String filiere; 
    private int effectif; 

    public Groupe() {
    }

    public Groupe(int id, String nomGroupe, String niveau, String filiere, int effectif) {
        this.id = id;
        this.nomGroupe = nomGroupe;
        this.niveau = niveau;
        this.filiere = filiere;
        this.effectif = effectif;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", nomGroupe='" + nomGroupe + '\'' +
                ", niveau='" + niveau + '\'' +
                ", filiere='" + filiere + '\'' +
                ", effectif=" + effectif +
                '}';
    }
}