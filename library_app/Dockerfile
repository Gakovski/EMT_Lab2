FROM maven:3.8.1-jdk-11-slim as build
RUN mkdir -p workspace
WORKDIR workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build /workspace/target/*.jar dockerized_app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "dockerized_app.jar"]