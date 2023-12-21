pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MviSkeletonApp"

includeBuild("build-logic")

include(":app")
include(":domain")
include(":feature")
include(":feature:main")
include(":data")
include(":library")
include(":library:mvi")
include(":library:account")
include(":library:pref")
