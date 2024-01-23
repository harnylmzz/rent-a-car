FROM maven:3.8.4-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean install

FROM openjdk:17
EXPOSE 8080
ENV PORT=8080
HEALTHCHECK --interval=30s --timeout=3s CMD curl -f http://localhost:$PORT/ || exit 1
COPY --from=build /app/target/rent-a-car.jar /app/rent-a-car.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "rent-a-car.jar"]
