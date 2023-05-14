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

    testImplementation(kotlin("test"))
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