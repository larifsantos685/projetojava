FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY src ./src
RUN chmod 777 mvnw
RUN ./mvnw package
RUN ls -l ./target
CMD["java","-jar","target/projetojava-0.0.1-SNAPSHOT.war"]
