FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/job-search-app.jar job-search-app.jar
ENTRYPOINT ["java","-jar","/job-search-app.jar"]