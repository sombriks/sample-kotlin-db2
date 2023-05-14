# Sample Kotlin DB2 project

Small project using modern kotlin to serve enterprise DB2 data

## Requirements

- Gradle 7
- Java 17
- Kotlin 1.8
- Container runtime
  - Podman or Docker
  - podman-compose or docker-compose

## Running db2

Go to **src/infrastrucutre** folder and `docker-compose up` the
*[docker-compose-development.yml](src%2Finfrastructure%2Fdocker-compose-development.yml)*
file. That will deliver to you a working DB2 instance.

Use `sample` as database name, `db2inst1` as username and `change-me-please` as
password.
