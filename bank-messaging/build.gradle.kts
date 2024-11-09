import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(platform("org.springframework.kafka:spring-kafka-bom:3.2.4"))

    implementation(project(":bank-application"))
    api("org.springframework.kafka:spring-kafka")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
