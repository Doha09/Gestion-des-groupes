/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Cours;
import beans.Etudiant;
import beans.Grpage;
import java.util.List;
import service.CoursService;
import service.EtudiantService;
import service.GrpageService;

/**
 *
 * @author ouahm
 */
public class Test {

    public static void main(String[] args) {

        EtudiantService es = new EtudiantService();
        CoursService cs = new CoursService();
        GrpageService gs = new GrpageService();

        Grpage groupe1 = new Grpage("Groupe A", "L3", "Informatique", 30);
        Grpage groupe2 = new Grpage("Groupe B", "L3", "Informatique", 25);

        gs.create(groupe1);
        gs.create(groupe2);

        List<Grpage> groupes = gs.findAll();
        System.out.println("Liste des groupes :");
        for (Grpage g : groupes) {
            System.out.println(g.getNomGroupe() + " | " + g.getNiveau() + " | " + g.getFiliere() + " | Effectif: " + g.getEffectif());
        }

        groupe1.setEffectif(28);
        gs.update(groupe1);
        System.out.println("\nGroupe modifié :");
        Grpage updatedGroupe = gs.findById(groupe1.getId());
        System.out.println(updatedGroupe.getNomGroupe() + " | Effectif: " + updatedGroupe.getEffectif());

        gs.delete(groupe2);
        System.out.println("\nGroupe supprimé : " + groupe2.getNomGroupe());

        Etudiant etudiant1 = new Etudiant("Doe", "John", "john.doe@example.com", groupe1);
        Etudiant etudiant2 = new Etudiant("Smith", "Jane", "jane.smith@example.com", groupe1);

        es.create(etudiant1);
        es.create(etudiant2);

        List<Etudiant> etudiants = es.findAll();
        System.out.println("\nListe des étudiants :");
        for (Etudiant e : etudiants) {
            System.out.println(e.getNom() + " " + e.getPrenom() + " | Email: " + e.getEmail());
        }

        etudiant1.setPrenom("Johnathan");
        es.update(etudiant1);
        System.out.println("\nÉtudiant modifié : " + es.findById(etudiant1.getId()).getPrenom());

        Cours cours1 = new Cours("Programmation Java", "M. Dupont", groupe1);
        Cours cours2 = new Cours("Bases de données", "Mme. Lefevre", groupe1);

        cs.create(cours1);
        cs.create(cours2);

        List<Cours> cours = cs.findAll();
        System.out.println("\nListe des cours :");
        for (Cours c : cours) {
            System.out.println(c.getIntitule() + " | Professeur: " + c.getProfesseur());
        }

        cours1.setIntitule("Programmation avancée en Java");
        cs.update(cours1);
        System.out.println("\nCours modifié : " + cs.findById(cours1.getId()).getIntitule());

        cs.delete(cours2);
        System.out.println("\nCours supprimé : " + cours2.getIntitule());
    }
}
