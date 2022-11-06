FROM openjdk:17-jdk

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

CMD ["java","-jar","/app.jar"]

#ENTRYPOINT [ "java", "-Dspring.profiles.active=dev", "-jar", "/app.jar" ]