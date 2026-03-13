FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY api-gateway/pom.xml api-gateway/

RUN ./mvnw dependency:go-offline -f api-gateway/pom.xml

COPY api-gateway/src api-gateway/src
RUN ./mvnw package -f api-gateway/pom.xml -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/api-gateway/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
