import de.inf_schauer.home_api.dto.TempDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "temp")
data class TempEntity(
    @Id @Column(columnDefinition = "uuid DEFAULT gen_random_uuid()") val uuid: UUID? = null,

    @Column(nullable = false) val device: String,

    @Column(nullable = false) val value: Float
) {
    companion object {
        fun fromDto(dto: TempDto) = TempEntity(
            device = dto.device, value = dto.value
        )
    }

    fun toDto() = TempDto(device = device, value = value)
}
