FROM amazoncorretto:17
COPY build/libs/kuitAos-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
