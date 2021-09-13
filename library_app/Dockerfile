FROM adoptopenjdk/openjdk16:alpine-jre
EXPOSE 8081
ADD target/docker_lab2.jar docker-lab2.jar
ENTRYPOINT ["java","-jar","docker-lab2.jar"]