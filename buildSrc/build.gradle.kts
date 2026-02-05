plugins {
    `kotlin-dsl`
    `groovy-gradle-plugin`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("io.micronaut.build.internal:micronaut-gradle-plugins:8.0.0-M13")
}
