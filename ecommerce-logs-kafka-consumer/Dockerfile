FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY target/ecommerce-logs-kafka-consumer-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

CMD ["java", "-jar", "app.jar"]