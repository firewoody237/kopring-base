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
    implementation(project(":kopring-base-integrated:tomcat"))
    implementation(project(":kopring-base-integrated:db"))
    implementation(project(":kopring-base-integrated:webservice"))

    implementation("org.springframework.boot:spring-boot-starter:$springVersion") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    implementation("org.springframework.boot:spring-boot-starter-web:$springVersion")
    compileOnly("org.springframework.boot:spring-boot-starter-tomcat:$springVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

val profile = if (project.hasProperty("profile")) project.property("profile").toString() else "local"

kotlin {
    sourceSets {
        named("main") {
            kotlin.srcDir("src/main/kotlin")
            resources.srcDirs("src/main/resources", "src/main/resources-\${profile}")
        }
    }
}