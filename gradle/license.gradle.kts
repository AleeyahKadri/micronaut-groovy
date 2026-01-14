plugins {
    id("com.github.hierynomus.license")
}

configure<nl.javadude.gradle.plugins.license.LicenseExtension> {
    header = rootProject.file("config/HEADER")
    strictCheck = true
    ignoreFailures = true
    mapping(
        mapOf(
            "kt" to "SLASHSTAR_STYLE",
            "java" to "SLASHSTAR_STYLE",
            "groovy" to "SLASHSTAR_STYLE"
        )
    )
    ext.set("year", "2017-2020")

    exclude("**/transaction/**")
    exclude("**/*.txt")
    exclude("**/*.html")
    exclude("**/*.xml")
    exclude("**/*.json")
    exclude("**/build-info.properties")
    exclude("**/git.properties")
    exclude("**/othergit.properties")
}
