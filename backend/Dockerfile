# Description: Dockerfile for the backend service
# Developer build

FROM openjdk:21
WORKDIR /app
COPY ./spring-api/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]