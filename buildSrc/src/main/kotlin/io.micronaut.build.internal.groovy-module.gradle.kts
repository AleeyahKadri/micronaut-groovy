plugins {
    id("io.micronaut.build.internal.module")
    id("io.micronaut.build.internal.groovy-base")
}

micronautBuild {
    enableBom = false
}

val documentation = configurations.findByName("documentation") ?: configurations.create("documentation")

dependencies {
    add("documentation", "com.github.javaparser:javaparser-core:3.27.1")

    add("testImplementation", platform("io.micronaut:micronaut-core-bom:4.10.12"))
    add("testImplementation", "io.micronaut:micronaut-runtime")
    add("testImplementation", "org.apache.groovy:groovy-test:4.0.18")
}

tasks.named("groovydoc") {
    (this as org.gradle.api.tasks.javadoc.Groovydoc).classpath += configurations.getByName("documentation")
}
