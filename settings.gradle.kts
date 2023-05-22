pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LeagueWiki"
include(":androidApp")
include(":shared")
include(":domain")
include(":repository")
include(":remote")
