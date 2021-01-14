FROM openjdk


WORKDIR /app

COPY target/Consumer-apihemocentro-1.0-SNAPSHOT-jar-with-dependencies.jar /app/Consumer-apihemocentro.jar

EXPOSE 3000
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "Consumer-apihemocentro.jar"]