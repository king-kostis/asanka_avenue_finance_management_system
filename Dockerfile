#Create runtime image
FROM eclipse-temurin:21.0.9_10-jre-alpine-3.23
# Set working directory
WORKDIR /asankawebapp
# Copy only the jar files
COPY /target/asankawebapp-0.0.1-SNAPSHOT.jar asankawebapp/asankawebapp.jar
# Open port 8080 to listen for connections
EXPOSE 8080
# Run program
ENTRYPOINT ["java", "-jar", "asankawebapp/asankawebapp.jar"]

