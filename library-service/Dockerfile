FROM openjdk:17-jdk
ADD build/libs/library-service-1.0.jar library-service.jar
ENTRYPOINT ["java", "-jar", "library-service.jar"]
EXPOSE 8080