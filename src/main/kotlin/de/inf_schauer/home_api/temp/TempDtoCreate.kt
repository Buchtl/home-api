package de.inf_schauer.home_api.temp

import java.time.Instant

data class TempDtoCreate(
    val device: String, val value: Float, val timestamp: Instant
)
