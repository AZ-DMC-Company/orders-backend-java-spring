# Stage 1: build JAR
FROM maven:3.9.1-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: run JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/orders-backend.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]