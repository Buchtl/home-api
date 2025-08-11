package de.inf_schauer.home_api.temp

data class TempResponse(
    val device: String, val value: Float
) {
    companion object {
        fun fromEntity(entity: TempEntity) = TempResponse(
            device = entity.device, value = entity.value
        )
    }

    fun toEntity() = TempEntity(
        device = device, value = value
    )
}