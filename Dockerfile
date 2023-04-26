FROM amazoncorretto:17-alpine-jdk
MAINTAINER ME
RUN wget --no-check-certificate "https://drive.google.com/file/d/1UiAm7JNCUezmDvUU_S5P6Lti_nEgGJ60/view?usp=share_link" -O ME-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "ME-0.0.1-SNAPSHOT.jar"]
