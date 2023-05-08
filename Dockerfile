FROM amazoncorretto:17-alpine-jdk
MAINTAINER ME
RUN apk update && apk add curl
RUN curl -LJO "https://www.dropbox.com/s/tyj29ecawua0l5g/ME-0.0.1-SNAPSHOT.jar?dl=0" -o "ME-0.0.1-SNAPSHOT.jar"


ENTRYPOINT ["java", "-jar", "ME-0.0.1-SNAPSHOT.jar"]
