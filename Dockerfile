FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rent-a-car-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/rent-a-car-0.0.1-SNAPSHOT.jar"]

