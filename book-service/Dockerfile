FROM openjdk:17-jdk
ADD build/libs/book-service-1.0.jar book-service.jar
ENTRYPOINT ["java", "-jar", "book-service.jar"]
EXPOSE 8080