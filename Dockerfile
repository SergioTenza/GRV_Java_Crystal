FROM openjdk:11
ADD target/docker-grv.war docker-grv.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-grv.jar"]