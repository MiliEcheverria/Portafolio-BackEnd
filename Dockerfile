FROM amazoncorretto:11-alpine-jdk
MAINTAINER ME
RUN apk --no-cache add wget
RUN wget -O me-app.jar "https://drive.google.com/file/d/1fDv4qdvs0aPyVoGhjvHoLADo5N2W29nn/view?usp=share_link"
ENTRYPOINT ["java", "-jar", "/me-app.jar"]
