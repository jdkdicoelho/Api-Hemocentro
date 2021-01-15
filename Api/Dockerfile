#CONTEÚDO DO Dockerfile
FROM maven:3.6.3-jdk-11-slim

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp	

RUN cd /usr/src/myapp
RUN mvn package


CMD java -jar ./target/ApiBancoDeSangue-0.0.1-SNAPSHOT-jar-with-dependencies.jar

EXPOSE 8080 