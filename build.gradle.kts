import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
}

group = "fr.lidonis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val kotestVersion = "4.6.1"
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}