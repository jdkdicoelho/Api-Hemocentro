FROM openjdk


WORKDIR /app

COPY target/ApiBancoDeSangue-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/ApiBancoDeSangue-0.0.1-SNAPSHOT-jar-with-dependencies.jar

EXPOSE 3000
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "ApiBancoDeSangue-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]