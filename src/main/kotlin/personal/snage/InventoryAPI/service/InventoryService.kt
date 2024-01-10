package personal.snage.InventoryAPI.service

import personal.snage.InventoryAPI.DTO.InventoryItemDTO

interface InventoryService {
    fun createItem(itemDTO: InventoryItemDTO): InventoryItemDTO
    fun getItem(itemId: Int): InventoryItemDTO
    fun getItems(): List<InventoryItemDTO>
    fun updateItem(itemDTO: InventoryItemDTO): InventoryItemDTO
    fun deleteItem(id: Int)
}