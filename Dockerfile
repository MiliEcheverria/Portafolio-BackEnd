
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorretto:11-alpine-jdk
MAINTAINER ME
copy target/ME-0.01-SNAPSHOT.jar me-app.jar
ENTRYPOINT ['java', "-jar", "/me-app.jar"]
