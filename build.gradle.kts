import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5" apply false
    id("io.spring.dependency-management") version "1.1.0" apply false

    kotlin("jvm") version "1.8.0" apply false
    kotlin("kapt") version "1.8.0" apply false
    kotlin("plugin.jpa") version "1.8.0" apply false
    kotlin("plugin.noarg") version "1.8.0" apply false
    kotlin("plugin.spring") version "1.8.0" apply false
    kotlin("plugin.allopen") version "1.8.0" apply false
    base
}

allprojects {
    group = "com.firewoody"
    version = "1.0-SNAPSHOT"

    repositories {
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
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
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
}

