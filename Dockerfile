FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests
FROM tomcat:9.0-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/cafeapp.war
ADD http://jdbc.postgresql.org/download/postgresql-42.7.1.jar /usr/local/tomcat/lib/
RUN useradd -m -s /bin/bash tomcat && chown -R tomcat:tomcat /usr/local/tomcat
USER tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]