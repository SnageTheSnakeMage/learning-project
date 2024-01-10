package personal.snage.InventoryAPI.utils

import org.springframework.stereotype.Service
import personal.snage.InventoryAPI.DTO.InventoryItemDTO
import personal.snage.InventoryAPI.ItemView.ItemView
@Service
class InventoryViewMapper: Mapper<InventoryItemDTO, ItemView> {
    override fun toEntity(domain: InventoryItemDTO): ItemView {
        return ItemView(
            domain.id,
            domain.name,
            domain.image
        )
    }

    fun batchToEntity(domainList: List<InventoryItemDTO>): List<ItemView>{
        val result: List<ItemView> = listOf(ItemView(-1,"Default",""))
        for(domain in domainList){
            result.addFirst(toEntity(domain))
        }
        return result
    }

    override fun fromEntity(entity: ItemView): InventoryItemDTO {
        return InventoryItemDTO(
            entity.id,
            entity.name,
            entity.image
        )
    }
}