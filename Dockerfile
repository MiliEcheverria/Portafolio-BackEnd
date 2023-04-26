FROM amazoncorretto:17-alpine-jdk
MAINTAINER ME
RUN apk --no-cache add wget
COPY app/ME-0.0.1-SNAPSHOT.jar /app/ME-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/ME-0.0.1-SNAPSHOT.jar"]
