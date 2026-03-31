# =========================
# STAGE 1: Build (Maven)
# =========================
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copiar solo el pom primero para cachear dependencias
COPY pom.xml ./

# Descargar dependencias (cache)
RUN mvn -B -q -DskipTests dependency:go-offline

# Copiar el resto del proyecto
COPY . .

# Compilar (sin tests)
RUN mvn -B -DskipTests clean package


# =========================
# STAGE 2: Runtime (lite)
# =========================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar el jar construido
COPY --from=builder /app/target/*.jar app.jar

# Puerto interno del contenedor
EXPOSE 8080

# Ejecutar (forzando puerto por si no está en application.properties)
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8080"]
