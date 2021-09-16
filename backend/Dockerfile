FROM maven:3.8.2-openjdk-11-slim AS build

RUN mkdir -p /workspace
COPY pom.xml /workspace
COPY src /workspace/src
WORKDIR /workspace

RUN mvn -f pom.xml clean package -DskipTests=true

FROM openjdk:11.0-jre-slim
COPY --from=build /workspace/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]