package com.example.ecs.systems

import com.example.ecs.components.WelcomeMessage
import com.mineinabyss.geary.ecs.accessors.ResultScope
import com.mineinabyss.geary.ecs.api.systems.TickingSystem
import com.mineinabyss.geary.minecraft.access.toGeary
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class WelcomeSystem : TickingSystem(), Listener {
    private val ResultScope.player by get<Player>()
    private val ResultScope.message by get<WelcomeMessage>()

    override fun ResultScope.tick() {
        player.sendMessage(message.message)
        entity.remove<WelcomeMessage>()
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