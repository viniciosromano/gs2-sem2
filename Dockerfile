FROM maven:3.8.7-openjdk-18-slim AS build
WORKDIR /opt/app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:18-jre-alpine
RUN mkdir /opt/app
COPY --from=build  /opt/app/target/app.jar /opt/app/app.jar
WORKDIR /opt/app
ENV PROFILE=dev
EXPOSE 22120
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]