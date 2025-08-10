package de.inf_schauer.home_api.service
import TempEntity
import de.inf_schauer.home_api.dto.TempDto
import de.inf_schauer.home_api.repository.TempRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DbService(private val repo: TempRepository) {

    @Transactional
    fun save(device: String, value: Float): TempDto {
        val entity = TempEntity(device = device, value = value)
        val saved = repo.save(entity)
        return saved.toDto()
    }
}
