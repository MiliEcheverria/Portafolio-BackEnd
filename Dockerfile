FROM amazoncorretto:17-alpine-jdk
MAINTAINER ME
RUN apk update && apk add curl
RUN curl -LJO "https://drive.google.com/file/d/1njsK4Ym3OP7wxnZRgGiCFZdq8PF5QcNC/view?usp=share_link" -o "ME-0.0.1-SNAPSHOT.jar"


ENTRYPOINT ["java", "-jar", "ME-0.0.1-SNAPSHOT.jar"]
