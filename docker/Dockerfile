# Stage 1: Build the application
FROM gradle:8.14.3-jdk21 AS build

WORKDIR /app

# Copy Gradle files separately for caching
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY src ./src

# Build the jar (replace 'bootJar' if needed)
RUN gradle clean bootJar --no-daemon

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/build/libs/*.jar home-api.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "home-api.jar"]
