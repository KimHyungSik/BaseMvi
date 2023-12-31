pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
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

include(":app")
include(":domain")
include(":feature")
include(":feature:main")
include(":data")
include(":library")
include(":library:mvi")
include(":library:account")
include(":library:pref")
include(":di")
