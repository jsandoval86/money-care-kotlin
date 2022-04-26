import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
    id("org.springframework.boot") version "2.4.1"
    id("org.jmailen.kotlinter") version "3.3.0"
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
        set("springBootVersion", "2.4.1")
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

    project.extra["springbootweb"] =
        "org.springframework.boot:spring-boot-starter-web:${springBootVersion}"
    project.extra["inject"] =
        "javax.inject:javax.inject:1"
    project.extra["springdata"] =
        "org.springframework.data:spring-data-jpa:${springBootVersion}"

    project.extra["test-junit-api"] = "org.junit.jupiter:junit-jupiter-api:5.8.1"
    project.extra["test-junit-engine"] = "org.junit.jupiter:junit-jupiter-engine:5.8.1"

    project.extra["mockito"] = "org.mockito:mockito-all:1.10.19"

}

dependencies {

    implementation(project.extra["springbootweb"] as String)
}

application {
    mainClass.set("com.app.Application")
}

