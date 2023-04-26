FROM amazoncorretto:17-alpine-jdk
MAINTAINER ME
RUN apk --no-cache add wget
COPY target/ME-0.0.1-SNAPSHOT.jar ME-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "ME-0.0.1-SNAPSHOT.jar"]
