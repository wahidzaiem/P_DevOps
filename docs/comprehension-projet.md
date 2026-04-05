# Document de compréhension – Projet Achat

## Stack technique
- Spring Boot 2.7.18 / Java 17
- Maven / MySQL 8.0.33
- Spring Data JPA, Lombok, Swagger (Springfox 3.0)

## Structure
- GroupId : `tn.esprit.rh`
- ArtifactId : `achat`
- Version : `1.0`
- Type : API REST Spring Boot

## Limites identifiées
| Catégorie | Limite |
|-----------|--------|
| Base de données | Dépendance MySQL externe |
| Tests | Aucun test présent |
| Qualité | Pas de Sonar ni couverture |
| Sécurité | Aucune validation OWASP |
| Conteneurisation | Pas de Dockerfile |
| Configuration | Accès DB non externalisé |

## Exécution manuelle (état initial)
```bash
# Prérequis : Java 17, MySQL, Maven
mvn spring-boot:run
