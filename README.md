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

```bash
docker-compose -f src/infrastructure/docker-compose-development.yml up db2
```

Use `sample` as database name, `db2inst1` as username and `change-me-please` as
password.

## Running the application 

Either run the main function inside `Main.kt` script or run the following gradle
command:

```bash
./gradlew run
```

The application will try to connect into db2 running into localhost:50000

## Using complete compose

It will build the application with a special environment flag so the database
configurations will try to find it inside the compose context.
See `src/main/resources` for more details.

## Noteworthy

Although the container-related files are NOT in project root (they are in src/infrastructure),
the project root folder keeps acting as container context.

Therefore, to build the app image:

```bash
./gradlew build
docker build -t sample:latest -f src/infrastructure/Dcokerfile .
```

Or, to compose up everything:


```bash
./gradlew build
docker build -t sample:latest -f src/infrastructure/Dcokerfile .
```

On one hand, we clean a little the project root, on the other side it demands
a little more tricky docker-compose file.

## Next steps

- sample Javalin tests
- integrate image building in gradle build itself; use built image on compose
- see if IDE configurations can provide hot-reload for Javalin
