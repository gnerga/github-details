FROM openjdk:17-alpine
COPY target/app-0.0.1-SNAPSHOT.jar app-0.0.1.jar
ENTRYPOINT ["java","-jar","app-0.0.1.jar"]