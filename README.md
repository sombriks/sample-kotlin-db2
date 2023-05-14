# Sample Kotlin DB2 project

Small project using modern kotlin with Javalin to serve enterprise DB2 data.
See [this blog post](https://sombriks.com/blog/0052-ibm-db2-quick-overview/)
for context.

## Requirements

- Gradle 7
- Java 17
- Kotlin 1.8
- Container runtime
  - Docker
  - docker-compose

## Running db2

Go to **src/infrastrucutre** folder and `docker-compose up` the
*[docker-compose-development.yml](src%2Finfrastructure%2Fdocker-compose-development.yml)*
file. That will deliver to you a working DB2 instance.

Use `sample` as database name, `db2inst1` as username and `change-me-please` as
password.

### NOTE

Current docker image used to spin up db2 database is deprecated, so this sample
might not work in the future until a reasonable new public db2 image appears.

## Running the application 

Either run the main function inside `Main.kt` script or run the following gradle
command:

```bash
./gradlew run
```

The application will try to connect into db2 running into localhost:50000
