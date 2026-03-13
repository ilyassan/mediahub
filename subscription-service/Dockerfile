FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY subscription-service/pom.xml subscription-service/

RUN ./mvnw dependency:go-offline -f subscription-service/pom.xml

COPY subscription-service/src subscription-service/src
RUN ./mvnw package -f subscription-service/pom.xml -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/subscription-service/target/*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
