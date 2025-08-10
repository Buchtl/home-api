package de.inf_schauer.home_api.service
import TempEntity
import de.inf_schauer.home_api.repository.TempRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DbService(private val repo: TempRepository) {

    @Transactional
    fun save(device: String, value: Float): TempEntity {
        val entity = TempEntity(device = device, value = value)
        return repo.save(entity)
    }
}
