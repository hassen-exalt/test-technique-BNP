# Étape 1: Builder l'application avec Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY ./backend/pom.xml .
RUN mvn dependency:go-offline
COPY ./backend/src ./src
RUN mvn clean package -DskipTests

# Étape 2: Image légère pour exécuter l'application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/demo-1.0.0.jar /app/demo.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/demo.jar"]
