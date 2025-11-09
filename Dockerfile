# ===== STAGE 1: build =====
FROM eclipse-temurin:17-jdk AS build
WORKDIR /workspace

# Copiamos wrapper y config de maven primero
COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml .

# Asegurar permisos y normalizar saltos de línea por si el repo viene con CRLF
RUN chmod +x mvnw && sed -i 's/\r$//' mvnw

# Precalentar dependencias (cachea bien)
RUN ./mvnw -q -DskipTests dependency:go-offline

# Copiar el código y compilar
COPY src src
RUN ./mvnw -q -DskipTests package


# ===== STAGE 2: runtime (solo ejecuta) =====
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia el jar construido en la etapa anterior
COPY --from=build /workspace/target/*.jar app.jar

# Render fija el puerto en la env var PORT
CMD ["sh","-c","java -Dserver.port=${PORT} -jar app.jar"]
