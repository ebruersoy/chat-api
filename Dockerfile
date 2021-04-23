FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/chat.jar
COPY ${JAR_FILE} chat.jar
ENTRYPOINT ["java","-Dspring.config.activate.on-profile=local" ,"-jar","/chat.jar"]