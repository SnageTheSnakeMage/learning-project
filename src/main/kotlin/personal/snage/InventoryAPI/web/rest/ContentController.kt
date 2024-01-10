package personal.snage.InventoryAPI.web.rest

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import  org.springframework.ui.Model
import personal.snage.InventoryAPI.DTO.InventoryItemDTO
import personal.snage.InventoryAPI.ItemView.ItemView
import personal.snage.InventoryAPI.utils.InventoryViewMapper

@Controller
class ContentController(
    private val rController: RestController,
    private val itemMapper: InventoryViewMapper
) {
    @GetMapping("/")
    fun homePage(model: Model): String  {
        val allItems = formatter(rController.getItems())
        model.addAttribute("Items", allItems)
        return "index"
    }

    fun formatter(allItems: List<InventoryItemDTO>): List<ItemView> {
        return itemMapper.batchToEntity(allItems)
    }
}