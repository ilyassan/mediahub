FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY user-service/pom.xml user-service/

RUN ./mvnw dependency:go-offline -f user-service/pom.xml

COPY user-service/src user-service/src
RUN ./mvnw package -f user-service/pom.xml -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/user-service/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
