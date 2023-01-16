import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("idea")
    id("jacoco")
    id("maven-publish")
    id("com.jfrog.bintray") version "1.8.4"
    id("com.diffplug.gradle.spotless") version "3.25.0"
    id("io.codearte.nexus-staging") version "0.21.1"
    id("de.marcphilipp.nexus-publish") version "0.4.0"
    id("de.undercouch.download") version "4.0.0"
}

group = "de.gematik.kether"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.apache.commons:commons-lang3:3.0")
    implementation("com.github.zafarkhaja:java-semver:0.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}