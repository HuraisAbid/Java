FROM eclipse-temurin:17-jdk as build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN ./mvnw -q -e -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/demo-1.0.0.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

