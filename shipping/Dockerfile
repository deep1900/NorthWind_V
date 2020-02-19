FROM openjdk:8-jre-slim

COPY build/libs/shipping-0.0.1-SNAPSHOT.jar /opt/app/

EXPOSE 8083

ENV SPRING_PROFILES_ACTIVE=set_at_command_line

ENTRYPOINT ["java", "-jar", "/opt/app/shipping-0.0.1-SNAPSHOT.jar"]
