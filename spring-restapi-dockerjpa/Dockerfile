FROM openjdk:17-alpine
EXPOSE 8081
COPY /target/book-restapi.jar   book-restapi.jar
ENTRYPOINT [ "java","-jar","book-restapi.jar" ]