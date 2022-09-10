plugins {
    kotlin("jvm") version "1.6.10"
}

subprojects {

    group = "io.reflectoring.reviewapp"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "java-library")
    apply(plugin = "java-library")
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }
}