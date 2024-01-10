package personal.snage.InventoryAPI.DTO

import java.time.Instant
import java.util.Date

data class InventoryItemDTO(
    var id: Int = -1,
    var name: String = "default",
    var location: String = "default",
    var dateObtained: Date = Date.from(Instant.now())
)
