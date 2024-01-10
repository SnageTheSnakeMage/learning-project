package personal.snage.InventoryAPI.DTO

import java.awt.Image
import java.time.Instant
import java.util.Date

data class InventoryItemDTO(
    var id: Int = -1,
    var name: String = "default",
    var image: String = "",
    var dateObtained: Date = Date.from(Instant.now())
)
