# orders-backend-java-spring/Dockerfile
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/orders-backend.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]