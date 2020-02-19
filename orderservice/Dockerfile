FROM openjdk:8-jre-slim

COPY build/libs/orderservice-0.0.1-SNAPSHOT.jar /opt/app/

EXPOSE 8084

ENV SPRING_PROFILES_ACTIVE=set_at_command_line

ENTRYPOINT ["java", "-jar", "/opt/app/orderservice-0.0.1-SNAPSHOT.jar"]
