package de.inf_schauer.home_api.dto

import TempEntity
import java.util.UUID

data class TempDto(
    val device: String,
    val value: Float
){
    companion object {
        fun fromEntity(entity: TempEntity) = TempDto(
            device = entity.device,
            value = entity.value
        )
    }

    fun toEntity() = TempEntity(
        device = device,
        value = value
    )
}