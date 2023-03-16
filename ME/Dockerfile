FROM amazoncorretto:17-alpine-jdk// de que imagen partimos
MAINTAINER ME // quien es el dueño
COPY target/ME-0.0.1-SNAPSHOT.jar me-app.jar                //va a copiar de nuestro proyecto el empaquetado y lo va a subir a github
ENTRYPOINT ["java", "-jar", "/me-app.jar"]   // es la instruccion que se va a ejecutar primero
