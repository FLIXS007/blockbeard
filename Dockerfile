# Etape 1 : Compilation du backend Spring Boot + integration du front-end HTML/CSS/JS
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copie du projet backend
COPY backend/pom.xml backend/pom.xml
COPY backend/src backend/src

# Copie des fichiers Front-end (HTML, CSS, JS, assets) dans les ressources statiques de Spring Boot
COPY *.html backend/src/main/resources/static/
COPY src backend/src/main/resources/static/src/
COPY public backend/src/main/resources/static/public/

# Generation du fichier .jar executable
WORKDIR /app/backend
RUN mvn clean package -DskipTests

# Etape 2 : Image legere d'execution Java 17
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/backend/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
