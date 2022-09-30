FROM adoptopenjdk/openjdk11:latest
#FROM java:8-jdk-alpine

LABEL maintainer="nestor.barralez@elektra.com.mx"

WORKDIR /opt

# CERTIFICADOS JKS DEV DOCUMENTDB
COPY documentdb/ssl/DEV/rds-truststore.jks /opt/documentdb/ssl/dev/rds-truststore.jks

# CERTIFICADOS JKS QA DOCUMENTDB
COPY documentdb/ssl/QA/rds-truststore.jks /opt/documentdb/ssl/qa/rds-truststore.jks

# CERTIFICADOS JKS PROD DOCUMENTDB
COPY documentdb/ssl/PROD/rds-truststore.jks /opt/documentdb/ssl/prod/rds-truststore.jks

COPY target/microservice-mongo-cert-demo-v2-0.0.1-SNAPSHOT.jar /opt/microservice-mongo-cert-demo-v2-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar", "/opt/microservice-mongo-cert-demo-v2-0.0.1-SNAPSHOT.jar"]