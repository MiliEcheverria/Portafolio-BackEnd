FROM amazoncorretto:17-alpine-jdk
MAINTAINER ME
RUN apk update && apk add curl
RUN curl -LJO "https://drive.google.com/file/d/1mPuFfO4egmXpKfSQPrDYOxOIXbdUEt59/view?usp=share_link" -o "ME-0.0.1-SNAPSHOT.jar"


ENTRYPOINT ["java", "-jar", "ME-0.0.1-SNAPSHOT.jar"]
