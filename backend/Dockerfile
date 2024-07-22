FROM openjdk:20-jdk-slim
WORKDIR /app
COPY ./spring-api/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
