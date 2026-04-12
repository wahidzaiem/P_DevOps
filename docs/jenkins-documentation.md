# Documentation du Pipeline Jenkins

## Structure du pipeline

| Stage | Description |
|-------|-------------|
| Checkout | Récupère le code depuis Git |
| Build | Compile le projet avec Maven |
| Test | Exécute les tests unitaires |
| Package | Crée le fichier JAR |
| Run | Lance l'application |

## Prérequis Jenkins

- Plugin Git installé
- Plugin Maven installé
- Maven 3 configuré
- JDK 17 configuré

## Déclencheurs

- Manuel : via bouton "Build Now"
- Automatique : webhook GitHub

## URLs importantes

- Jenkins : http://localhost:8080
- Application : http://localhost:8081
