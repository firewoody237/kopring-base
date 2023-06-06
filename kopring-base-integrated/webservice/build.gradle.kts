val springVersion: String by project

plugins {
    id("java")
}

group = "com.firewoody"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":kopring-base-integrated:common"))
    implementation("org.springframework.boot:spring-boot-starter-web:$springVersion") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    implementation("org.springframework.boot:spring-boot-starter-log4j2:$springVersion")
    implementation("org.apache.commons:commons-lang3:3.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}