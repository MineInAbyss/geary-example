package com.example

import com.mineinabyss.geary.ecs.api.autoscan.AutoscanComponent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("example:welcome_message")
@AutoscanComponent
data class WelcomeMessage(val message: String = "Welcome to the server")
