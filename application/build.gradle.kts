import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.insert-koin:koin-core:3.2.0")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.23")
    implementation("ch.qos.logback:logback-classic:1.4.0")
    testImplementation("io.insert-koin:koin-test:3.2.0")

    testImplementation("io.kotest:kotest-runner-junit5:5.4.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
