# 🎯Gestion-des-groupes

Grpage est une application de gestion conçue pour les établissements éducatifs. Elle permet de gérer les groupes d'étudiants, 
les cours associés, et les informations des étudiants de manière efficace et intuitive. L'application est développée en Java
SE avec une interface graphique basée sur Swing et utilise une base de données relationnelle MySQL  pour la persistance des données.

---

## 🎯 Fonctionnalités

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
## 🎯 Diagramme des classes
<img width="395" alt="Image" src="https://github.com/user-attachments/assets/0deec82d-b27d-4664-9982-91232cb16f5a" />


## 🛠️ Technologies & Bibliothèques Utilisées
### 🔷 Langage & Frameworks
- **Java SE 8** – Langage principal de l’application.
- **Swing** – Bibliothèque graphique Java pour concevoir les interfaces utilisateur.
- **JDBC (Java Database Connectivity)** – Pour la communication entre Java et la base de données MySQL.

### 🔷 Base de données
- **MySQL** – Système de gestion de base de données relationnelle utilisé pour stocker les groupes, étudiants, cours, utilisateurs...

### 🔷 IDE & Outils
- **NetBeans 8.0.2** – Environnement de développement intégré (IDE) utilisé pour coder, concevoir les interfaces graphiques et gérer le projet.
- **MagicDraw** – Utilisé pour la modélisation UML : diagrammes de cas d'utilisation, diagrammes de classes.
- **phpMyAdmin** – Pour la gestion visuelle de la base de données MySQL.
- **JFreeChart** – Bibliothèque pour créer des graphiques (Bar Chart pour la répartition des étudiants par groupe).

### 🔷 Bibliothèques externes
- **jBCrypt (`bcrypt-0.4.jar`)** – Pour le hachage sécurisé des mots de passe.

---
## 🎯 Structure du projet

```bash
GestionGroupes/
├── src/
│   ├── beans/                      # Modèles de données (Cours, Étudiant, Groupe, Utilisateur)
│   │   ├── Cours.java
│   │   ├── Etudiant.java
│   │   ├── Grpage.java
│   │   └── Utilisateur.java
│   ├── connexion/                 # Connexion à la base de données
│   │   └── Connexion.java
│   ├── dao/                       # Interface générique DAO
│   │   └── IDao.java
│   ├── gui/                       # Interfaces graphiques (Java Swing)
│   │   ├── CoursForm.java
│   │   ├── EtudiantForm.java
│   │   ├── FiltrerEtudiantsParGroupe.java
│   │   ├── GrpageForm.java
│   │   ├── MDIApplication.java
│   │   ├── Main.java
│   │   └── RechercherGroupeForm.java
│   ├── service/                   # Services pour la logique métier
│   │   ├── CoursService.java
│   │   ├── EtudiantService.java
│   │   ├── GrpageService.java
│   │   └── UtilisateurService.java
│   └── test/                      # Classe de test
│       └── Test.java
├── lib/                           # Bibliothèques externes (JDBC, JCalendar, BCrypt, Absolute Layout)
│   ├── mysql-connector-java-5.1.23-bin.jar
│   ├── jcalendar-1.4.jar
│   ├── jbcrypt-0.4.jar
│   └── AbsoluteLayout.jar
├── resources/                     # Ressources diverses (images, icônes, etc.)
└── README.md                      # Documentation du projet

---

## 🎯Structure de la Base de Données

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

