FROM maven:3.8.3-openjdk-17 AS builder
COPY ./ ./
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
COPY --from=builder /target/projects-market-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]