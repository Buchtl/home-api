import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "temp")
data class TempEntity(
    @Id
    @Column(columnDefinition = "uuid DEFAULT gen_random_uuid()")
    val uuid: UUID? = null,

    @Column(nullable = false)
    val device: String,

    @Column(nullable = false)
    val value: Float
)
