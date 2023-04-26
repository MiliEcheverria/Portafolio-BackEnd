FROM amazoncorretto:17-alpine-jdk
MAINTAINER ME
RUN apk --no-cache add wget
RUN wget -O me-app.jar "https://drive.google.com/file/d/1-aVGpx50doXw-Ld9pmEB_Ou0Am04_lD1/view?usp=share_link"
ENTRYPOINT ["java", "-jar", "me-app.jar"]
