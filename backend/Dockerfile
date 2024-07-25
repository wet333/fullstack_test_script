FROM maven AS build
WORKDIR /app
COPY ./spring-api /app
RUN mvn clean package

FROM openjdk:20-jdk-slim
WORKDIR /app
COPY --from=build app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
