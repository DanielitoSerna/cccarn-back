FROM amazoncorretto:11-alpine-jdk
MAINTAINER ccarn
COPY target/ccarn-0.0.1-SNAPSHOT.jar ccarn.jar
ENTRYPOINT ["java","-jar","/ccarn.jar"]