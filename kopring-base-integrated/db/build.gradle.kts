plugins {
    id("java")
}

group = "com.firewoody"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0") {
        exclude(group = "com.zaxxer", module = "HikariCP")
    }
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.apache.commons:commons-dbcp2:2.8.0")

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