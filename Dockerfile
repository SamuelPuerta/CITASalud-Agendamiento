# ===== STAGE 1: build (compila el jar) =====
FROM eclipse-temurin:17-jdk AS build
WORKDIR /workspace

# Copia lo mínimo para cachear dependencias
COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw -q -DskipTests dependency:go-offline

# Copia el código y compila
COPY src src
RUN ./mvnw -q -DskipTests package

# ===== STAGE 2: runtime (solo ejecuta) =====
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia el jar construido en la etapa anterior
COPY --from=build /workspace/target/*.jar app.jar

# Render fija el puerto en la env var PORT
CMD ["sh","-c","java -Dserver.port=${PORT} -jar app.jar"]
