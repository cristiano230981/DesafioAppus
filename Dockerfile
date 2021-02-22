FROM openjdk:8
ADD target/DesafioAppus-0.0.1-SNAPSHOT.jar DesafioAppus-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "DesafioAppus-0.0.1-SNAPSHOT.jar"]