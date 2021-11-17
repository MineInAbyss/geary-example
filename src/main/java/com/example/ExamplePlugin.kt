package com.example

import com.mineinabyss.geary.minecraft.access.toGeary
import com.mineinabyss.geary.minecraft.dsl.gearyAddon
import com.mineinabyss.idofront.plugin.registerEvents
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
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

    @EventHandler
    private fun onPlayerJoin(event: PlayerJoinEvent) =
        event.player.toGeary {
            set(
                WelcomeMessage(
                    Component.text("Welcome ")
                        .color(NamedTextColor.GREEN)
                        .append(
                            event.player.displayName().colorIfAbsent(NamedTextColor.WHITE)
                                .hoverEvent(Component.text("A cool frood!"))
                        )
                )
            )
        }
}