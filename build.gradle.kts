plugins {
    kotlin("jvm") version "1.9.23"
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.spring") version "1.9.23"
    id("maven-publish")
}

group = "de.inf_schauer"
version = "0.0.2-SNAPSHOT"

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "home-api"  // change to your artifact name
            version = project.version.toString()
        }
    }

    repositories {
        maven {
            name = "nexus"
            url = uri(
                if (version.toString().endsWith("SNAPSHOT")) "http://pi4b:8081/repository/internal-snapshot"
                else "http://pi4b:8081/repository/internal"
            )
            isAllowInsecureProtocol = true
            credentials {
                username = findProperty("nexus.user") as String? ?: ""
                password = findProperty("nexus.password") as String? ?: ""
            }
        }
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage") // optional, avoids JUnit 4
    }
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}
