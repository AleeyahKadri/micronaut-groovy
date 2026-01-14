plugins {
    id("io.micronaut.build.internal.module")
    id("io.micronaut.build.internal.groovy-base")
}

micronautBuild {
    enableBom = false
}

configurations.maybeCreate("documentation")

dependencies {
    val libs = project.extensions.getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java).named("libs")
    val mn = project.extensions.getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java).named("mn")
    
    "documentation"(libs.findLibrary("javaparser").get())

    "testImplementation"(mn.findLibrary("micronaut-runtime").get())
    "testImplementation"(libs.findLibrary("groovy-test").get())
}

tasks.named("groovydoc", org.gradle.api.tasks.javadoc.Groovydoc::class) {
    classpath += project.configurations.getByName("documentation")
}
