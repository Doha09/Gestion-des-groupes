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
## 🎯 **Problématique**

Dans de nombreuses institutions éducatives, la gestion des groupes d'étudiants devient rapidement complexe, surtout lorsqu'il y a un grand nombre d'étudiants répartis dans différents groupes et matières. Les responsables administratifs et les enseignants doivent souvent faire face à des tâches telles que l'assignation des étudiants à des groupes spécifiques, la recherche de groupes par nom, ainsi que la gestion des effectifs et des informations associées à chaque groupe.

Les systèmes manuels ou non centralisés peuvent entraîner des erreurs, des incohérences et une gestion inefficace des informations liées aux groupes et aux étudiants. Ces problèmes peuvent impacter non seulement l'organisation interne mais aussi l'expérience des étudiants et le suivi de leur parcours académique.

Ce projet vise à fournir une solution centralisée et automatisée permettant une gestion plus efficace des groupes d'étudiants.

---
## 🎯 Diagramme des cas d'utilisation
<img width="556" alt="Image" src="https://github.com/user-attachments/assets/503e11d3-b5a1-422f-98c6-daac835ce154" />
<img width="529" alt="Image" src="https://github.com/user-attachments/assets/c25e1399-8bcb-4fb8-93ea-777511fae7c2" />
<img width="556" alt="Image" src="https://github.com/user-attachments/assets/22031c3c-f39d-45ad-8c10-e48b22a33e6d" />

---
## 🎯 Diagramme de classe
<img width="439" alt="Image" src="https://github.com/user-attachments/assets/0f970f7a-23b1-412d-bf24-eed9d0e55037" />

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
## 🎯 Architecture du projet
<img width="770" alt="Image" src="https://github.com/user-attachments/assets/5f88723d-5e37-48d7-916a-e3a32bf01c9f" />

---


## 🎯 Structure de la Base de Données

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
CREATE TABLE Utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

```
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
│   │   ├── EnvoyerCodeFrame.java
│   │   ├── EtudiantForm.java
│   │   ├── FiltrerEtudiantsParGroupe.java
│   │   ├── GrapheEtudiantsParGroupe.java
│   │   ├── GrpageForm.java
│   │   ├── MDIApplication.java
│   │   ├── Main.java
│   │   └── RechercherGroupeForm.java
│   ├── service/                   # Services pour la logique métier
│   │   ├── CoursService.java
│   │   ├── EtudiantService.java
│   │   ├── GrpageService.java
│   │   ├── MailSender.java
│   │   └── UtilisateurService.java
│   └── test/                      # Classe de test
│       └── Test.java
├── images/                        # Dossier pour les images
└── Libraries/                     # Bibliothèques externes
    ├── mysql-connector-java-5.1.23-bin.jar
    ├── jcalendar-1.4.jar
    ├── jbcrypt-0.4.jar
    ├── AbsoluteLayout.jar
    ├── javax.mail.jar
    └── freechart-1.0.19.jar

```
---
## 🎥 Démonstration vidéo
https://github.com/user-attachments/assets/a6485f9e-bda4-4828-9beb-62f0dc8dbab5

---
## 🎥 Démonstration 2 vidéo
https://github.com/user-attachments/assets/1870cf45-c8b0-4f52-8ab1-b6e83702c032
