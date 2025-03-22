# Gestion-des-groupes

Grpage est une application de gestion conçue pour les établissements éducatifs. Elle permet de gérer les groupes d'étudiants, 
les cours associés, et les informations des étudiants de manière efficace et intuitive. L'application est développée en Java
SE avec une interface graphique basée sur Swing et utilise une base de données relationnelle MySQL  pour la persistance des données.

---

## Fonctionnalités

Gestion des groupes : Ajouter, modifier et supprimer des groupes.

Association des étudiants : Assigner des étudiants à des groupes spécifiques.

Filtrage des étudiants : Afficher les étudiants en fonction de leur groupe.

Recherche de groupes : Trouver un groupe par son nom.

Visualisation des données : Générer un diagramme en barres pour visualiser la répartition des étudiants par groupe.

---
## 🎯 Diagramme des cas d'utilisation
<img width="565" alt="Image" src="https://github.com/user-attachments/assets/a44033f6-806e-46b2-b240-3ae6070ddee2" />
<img width="529" alt="Image" src="https://github.com/user-attachments/assets/c25e1399-8bcb-4fb8-93ea-777511fae7c2" />
<img width="554" alt="Image" src="https://github.com/user-attachments/assets/30417ea9-23b6-4726-8314-044423319b10" />
---

## Structure de la Base de Données

La base de données MySQL est composée des tables suivantes :

```sql
CREATE TABLE Grpage (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom_groupe VARCHAR(50) NOT NULL,
    niveau VARCHAR(50) NOT NULL,
    filière VARCHAR(50) NOT NULL,
    effectif INT DEFAULT 0
);

CREATE TABLE Étudiant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prénom VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    groupe_id INT,
    FOREIGN KEY (groupe_id) REFERENCES Grpage(id) ON DELETE SET NULL
);

CREATE TABLE Cours (
    id INT PRIMARY KEY AUTO_INCREMENT,
    intitule VARCHAR(100) NOT NULL,
    professeur VARCHAR(50) NOT NULL,
    groupe_id INT,
    FOREIGN KEY (groupe_id) REFERENCES Grpage(id) ON DELETE SET NULL
);

