package com.example

import com.mineinabyss.geary.minecraft.access.toGeary
import com.mineinabyss.geary.minecraft.dsl.gearyAddon
import com.mineinabyss.idofront.plugin.registerEvents
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerLoginEvent
import org.bukkit.plugin.java.JavaPlugin

class ExamplePlugin : JavaPlugin(), Listener {
    override fun onEnable() {
        registerEvents(this)

        gearyAddon {
            autoscanComponents()
            systems(
                WelcomeSystem()
            )
        }
    }

    @Override
    private fun onPlayerJoin(event: PlayerLoginEvent) =
        event.player.toGeary { set<WelcomeMessage>(WelcomeMessage("Welcome ${event.player.displayName()}")) }
}