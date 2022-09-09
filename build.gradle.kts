plugins {
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
}

subprojects {

    group = "io.reflectoring.reviewapp"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-library")
    apply(plugin = "java-library")
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.7.RELEASE") {
                bomProperty("kotlin.version", "1.6.21")
            }
        }
    }
}