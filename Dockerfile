FROM openjdk:8-jdk-alpine
MAINTAINER Robert Jaufmann
WORKDIR /usr/src/mosterei
COPY ./target/mosterei-0.0.1-SNAPSHOT.jar /usr/src/mosterei
EXPOSE 8080
CMD ["java", "-jar", "mosterei-0.0.1-SNAPSHOT.jar"] 
