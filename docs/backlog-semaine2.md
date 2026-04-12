# Backlog – Semaine 2 : Intégration continue avec Jenkins

## User stories

### US-2.01
**En tant qu'** équipe, **je veux** installer et configurer un serveur Jenkins afin de disposer d'un outil d'intégration continue.  
**Critères d'acceptation :** Jenkins accessible sur `http://localhost:8080`  
**Statut :** ✅ Terminé

### US-2.02
**En tant qu'** équipe, **je veux** installer les plugins nécessaires (Git, Maven, Pipeline) afin que Jenkins puisse interagir avec notre dépôt et builder le projet.  
**Critères d'acceptation :** Plugins Git, Maven et Pipeline installés  
**Statut :** ✅ Terminé

### US-2.03
**En tant qu'** équipe, **je veux** configurer JDK 17 et Maven dans Jenkins afin que l'environnement de build soit prêt.  
**Critères d'acceptation :** JDK 17 et Maven configurés dans Manage Jenkins → Tools  
**Statut :** ✅ Terminé

### US-2.04
**En tant qu'** équipe, **je veux** créer un Jenkinsfile à la racine du projet afin de définir le pipeline en code.  
**Critères d'acceptation :** Fichier `Jenkinsfile` présent dans le dépôt avec les stages : Checkout, Build, Test, Package, Run  
**Statut :** ✅ Terminé

### US-2.05
**En tant qu'** équipe, **je veux** créer un pipeline Jenkins qui récupère le Jenkinsfile depuis GitHub (Pipeline script from SCM).  
**Critères d'acceptation :** Pipeline configuré avec l'URL du dépôt GitHub et la branche `main`  
**Statut :** ✅ Terminé

### US-2.06
**En tant qu'** équipe, **je veux** automatiser le déclenchement des builds via Poll SCM.  
**Critères d'acceptation :** Poll SCM configuré avec schedule `H/5 * * * *`  
**Statut :** ✅ Terminé

### US-2.07
**En tant qu'** équipe, **je veux** tester l'exécution automatique d'un build après un push sur GitHub.  
**Critères d'acceptation :** Un build se déclenche automatiquement (manuellement ou via Poll SCM) et réussit  
**Statut :** ✅ Terminé

### US-2.08
**En tant qu'** équipe, **je veux** documenter le pipeline Jenkins.  
**Critères d'acceptation :** Fichier `docs/jenkins-documentation.md` avec la structure, les prérequis et les URLs  
**Statut :** ✅ Terminé

### US-2.09
**En tant qu'** équipe, **je veux** mettre à jour le tableau Scrum avec l'avancement de la semaine 2.  
**Critères d'acceptation :** Toutes les tâches S2 marquées "Terminé"  
**Statut :** ✅ Terminé

---

## Sprint backlog (Semaine 2)

| ID | Tâche | Statut | Livrable |
|----|-------|--------|----------|
| S2-01 | Installer Jenkins | ✅ Terminé | Jenkins sur `http://localhost:8080` |
| S2-02 | Installer plugins (Git, Maven, Pipeline) | ✅ Terminé | Plugins listés dans Jenkins |
| S2-03 | Configurer JDK 17 | ✅ Terminé | Tools → JDK |
| S2-04 | Configurer Maven | ✅ Terminé | Tools → Maven |
| S2-05 | Créer Jenkinsfile | ✅ Terminé | `Jenkinsfile` à la racine |
| S2-06 | Configurer pipeline (SCM) | ✅ Terminé | Pipeline configuré |
| S2-07 | Configurer Poll SCM | ✅ Terminé | Schedule: `H/5 * * * *` |
| S2-08 | Tester build automatique | ✅ Terminé | Build #1 SUCCESS |
| S2-09 | Documenter le pipeline | ✅ Terminé | `docs/jenkins-documentation.md` |
| S2-10 | Mettre à jour tableau Scrum | ✅ Terminé | Sprint backlog S2 |

---

## Livrables attendus pour la Semaine 2

| Livrable | Statut | Emplacement |
|----------|--------|-------------|
| Pipeline Jenkins fonctionnel | ✅ Terminé | Jenkins UI |
| Jenkinsfile documenté | ✅ Terminé | `Jenkinsfile` + `docs/jenkins-documentation.md` |
| Preuve de connexion Git ↔ Jenkins | ✅ Terminé | Capture Poll SCM |
| Exécution automatique d'un build | ✅ Terminé | Historique Jenkins |
| Tableau Scrum mis à jour | ✅ Terminé | `docs/backlog-semaine2.md` |

---

## Détail du Jenkinsfile

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven-3'
        jdk 'JDK-17'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Récupération du code depuis Git...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Compilation du projet...'
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Exécution des tests...'
                sh 'mvn test'
            }
        }
        
        stage('Package') {
            steps {
                echo 'Création du JAR...'
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Run') {
            steps {
                echo 'Lancement de l\'application...'
                sh 'mvn spring-boot:run &'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline réussi !'
        }
        failure {
            echo 'Pipeline échoué !'
        }
    }
}
