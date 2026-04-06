# Document de compréhension du projet – Achat

## 1. Présentation générale

Le projet **achat** est une application backend Java fournie dans le cadre du module DevOps. Elle servira de base à l'industrialisation, l'automatisation et la sécurisation via une chaîne CI/CD.

## 2. Technologie et stack technique

| Composant | Technologie | Version |
|-----------|-------------|---------|
| Framework principal | Spring Boot | 2.7.18 |
| Langage | Java | 17 |
| Gestionnaire de dépendances | Maven | - |
| Base de données | MySQL | 8.0.33 (driver) |
| ORM | Spring Data JPA | - |
| Documentation API | Swagger (Springfox) | 3.0.0 |
| Réduction de code boilerplate | Lombok | 1.18.30 |
| Tests | Spring Boot Starter Test | - |

## 3. Structure identifiée (via le POM)

- **GroupId** : `tn.esprit.rh`
- **ArtifactId** : `achat`
- **Version actuelle** : `1.0`
- **Type** : Application web Spring Boot

### Dépendances principales et leur rôle

| Dépendance | Rôle |
|------------|------|
| `spring-boot-starter-data-jpa` | Accès et persistance des données |
| `spring-boot-starter-web` | Exposition d'API REST |
| `mysql-connector-java` | Connexion à la base MySQL |
| `lombok` | Générateur de getters/setters/constructeurs |
| `spring-boot-starter-test` | Tests unitaires et d'intégration |
| `springfox-boot-starter` + `swagger-ui` | Génération automatique de documentation API |

## 4. Limites techniques et organisationnelles identifiées

| Catégorie | Limite constatée |
|-----------|------------------|
| **Base de données** | Dépendance externe à MySQL, pas d'initialisation automatisée |
| **Tests** | Aucun test présent dans le POM (à vérifier dans le code source) |
| **Qualité** | Aucun plugin Sonar ou de couverture configuré |
| **Sécurité** | Aucune dépendance liée à la sécurité (OWASP, validation entrées) |
| **Documentation API** | Swagger présent mais configuration à vérifier |
| **Conteneurisation** | Aucun Dockerfile ni configuration pour conteneur |
| **Configuration** | Propriétés de connexion DB probablement en dur ou absentes |

## 5. Prérequis pour exécution manuelle (état initial)

- Java 17 installé
- MySQL installé et en cours d'exécution
- Base de données créée (nom à confirmer dans `application.properties`)
- Maven installé
- Commande : `mvn spring-boot:run`

## 6. Pistes d'amélioration DevOps (pour les semaines suivantes)

- Ajouter des tests unitaires avec JUnit
- Configurer Sonar pour analyse qualité
- Créer un Dockerfile
- Externaliser les configurations sensibles
- Ajouter un plugin de vérification des vulnérabilités sur les dépendances
- Mettre en place un pipeline Jenkins

## 7. Conclusion – état à l'issue de la semaine 1

L'application est une API Spring Boot classique, sans industrialisation ni automatisation. Elle constitue un bon candidat pour appliquer l'ensemble des briques DevOps demandées (CI/CD, tests, qualité, conteneurisation, supervision, sécurité).

---
