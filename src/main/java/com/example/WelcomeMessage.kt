package com.example

import com.mineinabyss.geary.ecs.api.autoscan.AutoscanComponent
import net.kyori.adventure.text.Component

@AutoscanComponent
data class WelcomeMessage(val message: Component = Component.text("Welcome to the server"))
