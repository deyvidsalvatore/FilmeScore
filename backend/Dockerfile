FROM maven:3.8.8-eclipse-temurin-21-alpine AS  builder

WORKDIR /app
COPY . .

RUN mvn clean package

FROM eclipse-temurin:21.0.1_12-jre-alpine

COPY --from=builder /app/target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]