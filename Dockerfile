# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/make-up-back-0.0.1-SNAPSHOT.jar /app/make-up-back.jar

# Expose port 8080 (assuming your Spring Boot app runs on this port)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "make-up-back.jar"]