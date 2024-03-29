import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
}

repositories {
    mavenCentral()
    // Only necessary if you use jqwik's SNAPSHOT releases
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    testImplementation("net.jqwik:jqwik-kotlin:1.6.5")
    testImplementation("org.assertj:assertj-core:3.22.0")
}

tasks.withType<Test> {
    useJUnitPlatform()

    // To allow other naming conventions
    include("**/*Properties.class")
    include("**/*Examples.class")
    include("**/*Test.class")
    include("**/*Tests.class")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xjsr305=strict", // Strict interpretation of nullability annotations in jqwik API
            "-Xemit-jvm-type-annotations" // Enable nnotations on type variables
        )
        jvmTarget = "11" // 1.8 or above
        javaParameters = true // Get correct parameter names in jqwik reporting
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "7.4.2"
}
