FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY media-service/pom.xml media-service/

RUN ./mvnw dependency:go-offline -f media-service/pom.xml

COPY media-service/src media-service/src
RUN ./mvnw package -f media-service/pom.xml -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/media-service/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
