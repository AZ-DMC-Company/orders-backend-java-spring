
# orders-backend-java-spring/Dockerfile
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/orders-backend.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]