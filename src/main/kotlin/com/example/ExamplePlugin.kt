package com.example

import com.example.ecs.systems.WelcomeSystem
import com.mineinabyss.geary.minecraft.dsl.gearyAddon
import org.bukkit.plugin.java.JavaPlugin

class ExamplePlugin : JavaPlugin() {
    override fun onEnable() {
        gearyAddon {
            autoscanComponents()
            systems(
                WelcomeSystem()
            )
        }
    }
}