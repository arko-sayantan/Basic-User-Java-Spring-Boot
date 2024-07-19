FROM maven:3.9.7-amazoncorretto-21 AS build
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package
# CREATE AN IMAGE
FROM eclipse-temurin:21-jdk-jammy 
EXPOSE 8082
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh","-c", "java -jar /app.jar" ]

