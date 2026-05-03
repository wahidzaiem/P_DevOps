FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/achat-1.0.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"]
