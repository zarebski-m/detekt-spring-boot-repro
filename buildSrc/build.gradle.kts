import java.util.Properties

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    jvmTarget.set("11")
}

repositories {
    gradlePluginPortal()
}

val props = Properties().apply { load(file("../gradle.properties").inputStream()) }
val kotlinVersion: String = props.getProperty("kotlin.version")
val detektVersion: String = props.getProperty("detekt.version")
val springBootVersion: String = props.getProperty("spring-boot.version")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detektVersion")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    implementation("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
}
