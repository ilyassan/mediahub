FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY config-server/pom.xml config-server/

RUN ./mvnw dependency:go-offline -f config-server/pom.xml

COPY config-server/src config-server/src
RUN ./mvnw package -f config-server/pom.xml -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/config-server/target/*.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]
