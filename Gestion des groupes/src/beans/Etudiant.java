package beans;

public class Etudiant {
    private int id; 
    private String nom;
    private String prenom; 
    private String email; 
    private Groupe groupe; 

    public Etudiant() {
    }

    
    public Etudiant(int id, String nom, String prenom, String email, Groupe groupe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.groupe = groupe;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

   
    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", groupe=" + groupe + 
                '}';
    }
}