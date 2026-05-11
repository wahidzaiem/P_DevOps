# Étape 1 : Build avec Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image d'exécution
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Copier le fichier de configuration
COPY src/main/resources/application.properties ./application.properties
EXPOSE 8081
ENV SERVER_PORT=8081
# Lancer avec le fichier de configuration
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=/app/application.properties", "--server.port=8081"]
