import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
}


dependencies {

    implementation(project.extra["springbootweb"] as String)
    implementation(project.extra["springdata"] as String)
    implementation(project.extra["jaxb"] as String)
    implementation(project.extra["h2"] as String)

    implementation(project(":domain"))
    implementation(project(":application"))

    testImplementation(project.extra["spring-boot-test"] as String)

    implementation( project.extra["lombok"] as String)
    annotationProcessor( project.extra["lombok"] as String)
    implementation(kotlin("stdlib-jdk8"))

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
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}