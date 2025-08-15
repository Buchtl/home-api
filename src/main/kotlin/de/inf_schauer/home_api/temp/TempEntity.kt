package de.inf_schauer.home_api.temp

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "temperature")
data class TempEntity(
    @Id @Column(columnDefinition = "uuid DEFAULT gen_random_uuid()") val uuid: UUID? = null,

    @Column(nullable = false) val device: String,

    @Column(nullable = false) val value: Float
)