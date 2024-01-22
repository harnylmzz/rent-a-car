FROM openjdk:17
EXPOSE 8080
ADD target/rent-a-car.jar rent-a-car.jar
ENTRYPOINT ["java", "-jar", "rent-a-car.jar"]
