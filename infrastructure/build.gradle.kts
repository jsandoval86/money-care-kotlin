import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
}


dependencies {

    implementation(project.extra["springbootweb"] as String)
    implementation(project.extra["springdata"] as String)

    implementation(project(":domain"))
    implementation(project(":application"))

    testImplementation(project.extra["spring-boot-test"] as String)

    implementation( project.extra["lombok"] as String)
    annotationProcessor( project.extra["lombok"] as String)

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
        allWarningsAsErrors = true
    }
}

application {
    mainClass.set("com.moneycare.Application")
}
