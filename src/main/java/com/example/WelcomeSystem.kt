package com.example

import com.mineinabyss.geary.ecs.accessors.ResultScope
import com.mineinabyss.geary.ecs.api.systems.TickingSystem
import org.bukkit.entity.Player

class WelcomeSystem : TickingSystem() {
    private val ResultScope.player by get<Player>()
    private val ResultScope.message by get<WelcomeMessage>()

    override fun ResultScope.tick() {
        player.sendMessage(message.message)
        entity.remove<WelcomeMessage>()
    }
}