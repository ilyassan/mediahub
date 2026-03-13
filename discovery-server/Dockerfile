FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY discovery-server/pom.xml discovery-server/

RUN ./mvnw dependency:go-offline -f discovery-server/pom.xml

COPY discovery-server/src discovery-server/src
RUN ./mvnw package -f discovery-server/pom.xml -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/discovery-server/target/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
