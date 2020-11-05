FROM openjdk:12-alpine
RUN addgroup --system spring && adduser --system --ingroup spring --shell /bin/bash spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} demoportal.jar
ENTRYPOINT ["java","-jar","/demoportal.jar"]
