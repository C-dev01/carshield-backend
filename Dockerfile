# Step 1: Build the JAR using Maven with Java 21
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Step 2: Run the application on Java 21 JRE
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]