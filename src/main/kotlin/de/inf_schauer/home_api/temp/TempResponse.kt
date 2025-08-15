package de.inf_schauer.home_api.temp

import java.time.Instant

data class TempResponse(
    val device: String, val value: Float, val timestamp: Instant
) {
    companion object {
        fun fromEntity(entity: TempEntity) = TempResponse(
            device = entity.device, value = entity.value, timestamp = entity.timestamp
        )
    }
}