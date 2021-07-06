FROM openjdk:9
VOLUME /tmp
EXPOSE 8080
ADD target/demo_devops-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
