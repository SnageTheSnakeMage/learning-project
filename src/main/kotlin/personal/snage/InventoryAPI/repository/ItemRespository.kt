package personal.snage.InventoryAPI.repository

import org.springframework.data.repository.CrudRepository
import personal.snage.InventoryAPI.entity.InventoryItem

interface ItemRespository: CrudRepository<InventoryItem, Int> {

}