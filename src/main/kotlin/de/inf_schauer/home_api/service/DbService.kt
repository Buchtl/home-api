package de.inf_schauer.home_api.service

import de.inf_schauer.home_api.repository.TempRepository
import de.inf_schauer.home_api.temp.TempEntity
import de.inf_schauer.home_api.temp.TempResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DbService(private val repo: TempRepository) {

    @Transactional
    fun save(device: String, value: Float): TempResponse {
        val entity = TempEntity(device = device, value = value)
        val saved = repo.save(entity)
        return TempResponse.fromEntity(saved)
    }
}
