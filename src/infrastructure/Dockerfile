FROM gradle:7.4-jdk17

ADD .
RUN ls
RUN gradle build
ENTRYPOINT /app/bin/sample-kotlin-db2
