package de.inf_schauer.home_api.temp

data class TempDtoCreate(
    val device: String, val value: Float
) {
    fun toEntity(): TempEntity = TempEntity(
        device = device, value = value
    )
}
