FROM maven:3.8.1-jdk-11 AS build
WORKDIR usr/src/app
COPY . ./
RUN mvn clean package -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk11:latest
ARG JAR_NAME="chat"
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/${JAR_NAME}.jar ./app.jar
ENTRYPOINT ["java","-Dspring.config.activate.on-profile=local" ,"-jar","./app.jar"]