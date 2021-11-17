pluginManagement {
    repositories {
        gradlePluginPortal()
        // Add our repository to be able to access the plugin
        maven("https://repo.mineinabyss.com/releases")
    }

    plugins {
        val kotlinVersion: String by settings
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion
        id("com.github.johnrengelman.shadow") version "6.0.0"
    }

    //Use same version across all conventions
    val idofrontConventions: String by settings

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.mineinabyss.conventions"))
                useVersion(idofrontConventions)
        }
    }
}

rootProject.name = "example"