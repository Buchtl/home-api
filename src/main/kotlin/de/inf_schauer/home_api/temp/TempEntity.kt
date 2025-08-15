package de.inf_schauer.home_api.temp

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "temperature")
data class TempEntity(
    @Id @GeneratedValue val uuid: UUID? = null,

    @Column(nullable = false) val device: String,

    @Column(nullable = false) val value: Float,

    @Column(nullable = false) val timestamp: Instant
)