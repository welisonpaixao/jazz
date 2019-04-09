# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
#Copy Jar to image
COPY target/jazz-0.0.1-SNAPSHOT.jar /app/app.war 

WORKDIR /app

#ENV MYSQL_DB_USERNAME=root
#ENV MYSQL_DB_PASSWORD=root
#ENV MYSQL_HOST=172.17.0.2

EXPOSE 5888

CMD ["/usr/bin/java", "-jar", "/app/app.war"]
