import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
}

dependencies {
    implementation(platform("org.springframework:spring-framework-bom:6.1.14"))
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.9.0"))


    api(project(":bank-application"))

    implementation("org.springframework:spring-webflux")
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-aspects")

    testImplementation("org.springframework:spring-test")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
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
