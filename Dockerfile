# Fetching latest version of Java
FROM eclipse-temurin:17-jdk-alpine

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/prometheus-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "prometheus-0.0.1-SNAPSHOT.jar"]