FROM openjdk:8-jdk-alpine
LABEL maintainer="myemail@mycompany.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV app_host ""
ENTRYPOINT ["java","-jar","/app.jar"]