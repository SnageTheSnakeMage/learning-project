package personal.snage.InventoryAPI.web.rest

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import personal.snage.InventoryAPI.DTO.InventoryItemDTO
import personal.snage.InventoryAPI.service.InventoryService
@RestController
class RestController(
    private val inventoryServ: InventoryService
){
    @PostMapping
    fun createItem( @RequestBody itemDTO: InventoryItemDTO): ResponseEntity<InventoryItemDTO>? {
        return try {
            ResponseEntity(inventoryServ.createItem(itemDTO), HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            null
        }
    }
    @GetMapping("/{itemId}")
    fun getItem(@PathVariable itemId: Int) : InventoryItemDTO {
        return inventoryServ.getItem(itemId)
    }
    @GetMapping("/items")
    fun getItems(): List<InventoryItemDTO> {
        return inventoryServ.getItems()
    }

    @PutMapping
    fun updateItem(@RequestBody itemDTO: InventoryItemDTO): ResponseEntity<InventoryItemDTO> {
        return ResponseEntity.ok(inventoryServ.updateItem(itemDTO))
    }

    @DeleteMapping("{id}")
    fun deleteItem(@PathVariable id: Int): ResponseEntity<Unit>{
        return ResponseEntity(inventoryServ.deleteItem(id), HttpStatus.NO_CONTENT)
    }

}