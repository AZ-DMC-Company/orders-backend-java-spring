FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN ./mvnw package -DskipTests
EXPOSE 8080
CMD ["java","-jar","target/backend-repo-0.0.1-SNAPSHOT.jar"]