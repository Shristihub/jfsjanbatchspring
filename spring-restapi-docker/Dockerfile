FROM openjdk:17-alpine
EXPOSE 8080
COPY /target/spring-restapi.jar spring-rest.jar
ENTRYPOINT [ "java","-jar", "spring-rest.jar"]