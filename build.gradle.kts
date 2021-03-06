import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.4.30"
}

group = "pbt.kotlin"
version = "0.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {

    testImplementation("net.jqwik:jqwik:1.5.0")
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
        javaParameters = true // Required to get correct parameter names in reporting
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "6.7.1"
}
