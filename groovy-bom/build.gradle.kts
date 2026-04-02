plugins {
    id("io.micronaut.build.internal.bom")
}

dependencies {
    api(platform("org.apache.groovy:groovy-bom:${libs.versions.groovy.get()}"))
}

micronautBom {
    suppressions {
        // GORM does not yet work with Groovy 4
        acceptedLibraryRegressions.addAll(
            listOf(
                "micronaut-mongo-gorm",
                "micronaut-graphql-gorm",
                "micronaut-hibernate-gorm",
                "micronaut-neo4j-gorm",
                "micronaut-multitenancy-gorm",
                "micronaut-gorm-common"
            )
        )
    }
}
