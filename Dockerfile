# --- Build stage ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copiar pom / wrapper primero para aprovechar cache
COPY pom.xml mvnw .mvn/ ./
# Si usas mvnw, asegúrate de tenerlo en el repo (start.spring.io suele incluirlo)
# Copia el código
COPY src ./src

# Empaqueta la aplicación (sin tests para acelerar). Cambia si necesitas ejecutar tests en CI.
RUN mvn -B -DskipTests package

# --- Runtime stage ---
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el jar generado desde el stage build. Usamos wildcard por si cambia el nombre.
COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
