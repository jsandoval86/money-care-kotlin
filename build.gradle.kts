import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
    id("org.springframework.boot") version "2.4.1"
    id("org.jmailen.kotlinter") version "3.3.0"
    kotlin("kapt") version "1.4.20"
    application
}

java.sourceCompatibility = JavaVersion.VERSION_11


allprojects {

    group = "com.moneycare"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        jcenter()
    }

    ext {
        set("springBootVersion", "2.7.5")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
            allWarningsAsErrors = true
        }
    }

    val springBootVersion = rootProject.extra["springBootVersion"]

    project.extra["inject"]         = "javax.inject:javax.inject:1"
    project.extra["jaxb"]           = "javax.xml.bind:jaxb-api:2.3.1"
    project.extra["lombok"]         = "org.projectlombok:lombok:1.18.20"
    project.extra["jackson-kotlin"] = "com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3"
    project.extra["hibernate-validator"] = "org.hibernate:hibernate-validator:6.2.5.Final"
    project.extra["springbootweb"]  = "org.springframework.boot:spring-boot-starter-web:${springBootVersion}"
    project.extra["springdata"]     = "org.springframework.boot:spring-boot-starter-data-jpa:${springBootVersion}"
    project.extra["spring-search"] = "com.sipios:spring-search:0.2.4"

    // Test
    project.extra["test-junit-api"] = "org.junit.jupiter:junit-jupiter-api:5.8.1"
    project.extra["test-junit-engine"] = "org.junit.jupiter:junit-jupiter-engine:5.8.1"
    project.extra["mockito"] = "org.mockito:mockito-all:1.10.19"
    project.extra["spring-boot-test"] = "org.springframework.boot:spring-boot-starter-test:${springBootVersion}"
    project.extra["h2"] = "com.h2database:h2:2.1.214"

}

application {
    mainClass.set("com.moneycare.Application")
}

