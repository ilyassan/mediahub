FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

COPY discovery-server/pom.xml discovery-server/
COPY config-server/pom.xml config-server/
COPY user-service/pom.xml user-service/
COPY media-service/pom.xml media-service/
COPY subscription-service/pom.xml subscription-service/

RUN ./mvnw dependency:go-offline -pl user-service -am

COPY user-service/src user-service/src
RUN ./mvnw package -pl user-service -am -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/user-service/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
