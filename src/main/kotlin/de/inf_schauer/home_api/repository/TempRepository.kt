package de.inf_schauer.home_api.repository

import TempEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TempRepository : JpaRepository<TempEntity, UUID>
