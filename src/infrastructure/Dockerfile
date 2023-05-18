# see gradle.build.kt for proper details on image build
FROM eclipse-temurin:17-jre-alpine

ENV APP_PROFILE compose

ADD build/distributions/sample-kotlin-db2-1.0-SNAPSHOT.zip /application.zip

RUN unzip /application.zip ; mv /sample-kotlin-db2-1.0-SNAPSHOT /app ; rm /application.zip

ENTRYPOINT /app/bin/sample-kotlin-db2
