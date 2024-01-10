package personal.snage.InventoryAPI.utils

import org.springframework.stereotype.Service
import personal.snage.InventoryAPI.DTO.InventoryItemDTO
import personal.snage.InventoryAPI.entity.InventoryItem
@Service
class InventoryItemMapper: Mapper<InventoryItemDTO, InventoryItem> {
    override fun fromEntity(entity: InventoryItem): InventoryItemDTO {
        return InventoryItemDTO(
            entity.id,
            entity.name,
            entity.image,
            entity.dateObtained
        )
    }

    override fun toEntity(domain: InventoryItemDTO): InventoryItem {
        return InventoryItem(
            domain.id,
            domain.name,
            domain.image,
            domain.dateObtained
        )
    }

}