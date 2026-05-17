# Rapport OWASP Dependency-Check

## Vulnérabilités critiques identifiées

| Dépendance | Version | CVE | Score |
|------------|---------|-----|-------|
| snakeyaml | 1.30 | CVE-2022-1471 | 9.8 CRITICAL |
| spring-web | 5.3.31 | CVE-2024-22259 | 8.1 HIGH |
| spring-core | 5.3.31 | CVE-2024-22259 | 8.1 HIGH |
| tomcat-embed | 9.0.83 | Multiples | 9.8 CRITICAL |

## Actions correctives recommandées

1. Mettre à jour Spring Boot vers 3.2.x
2. Mettre à jour snakeyaml vers 2.0+
3. Mettre à jour Tomcat vers 9.0.98+

**Date d'analyse:** $(date)
