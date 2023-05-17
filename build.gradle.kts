plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "me.sombriks"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:5.5.0")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.zaxxer:HikariCP:3.3.0")
    implementation("org.jdbi:jdbi3-kotlin:3.38.2")

    testImplementation(kotlin("test"))

    runtimeOnly("com.ibm.db2:jcc:11.5.8.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("me.sombriks.MainKt")
}
