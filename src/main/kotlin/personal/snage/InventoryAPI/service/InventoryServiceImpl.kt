package personal.snage.InventoryAPI.service

import org.springframework.stereotype.Service
import personal.snage.InventoryAPI.DTO.InventoryItemDTO
import personal.snage.InventoryAPI.repository.ItemRespository
import personal.snage.InventoryAPI.utils.InventoryItemMapper
import java.time.Instant
import java.util.*
@Service
class InventoryServiceImpl(
    private  val itemRespository: ItemRespository,
    private val inventoryItemMapper: InventoryItemMapper
): InventoryService {
    override fun createItem(itemDTO: InventoryItemDTO): InventoryItemDTO {
        if((itemDTO.id == -1)) {
            val Item = itemRespository.save(inventoryItemMapper.toEntity(itemDTO))
            return inventoryItemMapper.fromEntity(Item)
        }
        else{
            throw IllegalArgumentException("Id is taken or for some other reason is not empty or default value")
        }
    }

    override fun getItem(itemId: Int): InventoryItemDTO {
        val item = itemRespository.findById(itemId).get()
        return inventoryItemMapper.fromEntity(item)
    }

    override fun getItems(): List<InventoryItemDTO> {
        val allItems = itemRespository.findAll()
        val ItemList: MutableList<InventoryItemDTO> = mutableListOf()
        for (_item in allItems){
            ItemList.add(inventoryItemMapper.fromEntity(_item))
        }
        return ItemList
    }

    override fun updateItem(itemDTO: InventoryItemDTO): InventoryItemDTO {
        if(!itemRespository.existsById(itemDTO.id)) {
            throw IllegalArgumentException("Item does not exist")
        }
        if(itemDTO.id == -1) throw IllegalArgumentException("Please provide the id of the item you are replacing")
        if (itemDTO.name == "default") itemDTO.name = getItem(itemDTO.id).name
        if (itemDTO.image == "") itemDTO.image = getItem(itemDTO.id).image
        if (itemDTO.dateObtained == Date.from(Instant.now())) itemDTO.dateObtained = getItem(itemDTO.id).dateObtained
        itemRespository.save(inventoryItemMapper.toEntity(itemDTO))
        return itemDTO
    }

    override fun deleteItem(id: Int) {
        if(!itemRespository.existsById(id)) throw IllegalArgumentException("Please provide the id of the item you are deleting")
        itemRespository.deleteById(id)
    }

}