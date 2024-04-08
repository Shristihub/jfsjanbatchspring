FROM openjdk:11
EXPOSE 8080
COPY /target/spring-doctorapi.jar spring-doctorrest.jar
ENTRYPOINT [ "java","-jar","spring-doctorrest.jar" ]