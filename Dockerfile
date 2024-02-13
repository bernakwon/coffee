FROM openjdk17:jre-17.0.6_10-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar",  "/app.jar"]