val idofrontVersion: String by project
val gearyVersion: String by project

plugins {
    id("com.mineinabyss.conventions.kotlin")
    kotlin("plugin.serialization")
    id("com.mineinabyss.conventions.papermc")
    id("com.mineinabyss.conventions.slimjar")
    id("com.mineinabyss.conventions.copyjar")
}

repositories {
    mavenCentral()
    maven("https://repo.mineinabyss.com/releases")
}

dependencies {
    // Kotlin spice dependencies
    compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json")

    // Shaded
    implementation("com.mineinabyss:idofront:$idofrontVersion")

    // Plugin Dependencies
    compileOnly("com.mineinabyss:geary-platform-papermc:$gearyVersion")
}