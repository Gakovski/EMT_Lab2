FROM maven:3.8.1-jdk-11-slim AS build
RUN mkdir -p workspace
WORKDIR workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml  clean install -DskipTests=true
RUN find -name "*.jar"

FROM node:14-alpine
WORKDIR workspace
COPY frontend /workspace/frontend
RUN npm install
COPY . .
EXPOSE 3000
CMD ["npm", "start"]

FROM openjdk:11
COPY --from=build workspace/target/*.jar dockerized_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","dockerized_app.jar"]
