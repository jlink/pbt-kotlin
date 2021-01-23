import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.4.21"
}

group = "pbt.kotlin"
version = "0.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {

    testImplementation("net.jqwik:jqwik:1.4.0-SNAPSHOT")
    testImplementation("org.assertj:assertj-core:3.18.1")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf(
			"-Xjsr305=strict",
			"-Xemit-jvm-type-annotations" // Required for annotations on type variables
		)
        jvmTarget = "11"
        javaParameters = true
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "6.7.1"
}
