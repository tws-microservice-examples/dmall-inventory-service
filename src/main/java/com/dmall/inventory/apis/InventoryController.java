package com.dmall.inventory.apis;

import com.dmall.inventory.apis.common.NotEnoughQuantityException;
import com.dmall.inventory.apis.common.NotFoundException;
import com.dmall.inventory.apis.dto.InventoryCommandDTO;
import com.dmall.inventory.apis.dto.InventoryDTO;
import com.dmall.inventory.dao.InventoryRepository;
import com.dmall.inventory.domain.model.Inventory;
import com.dmall.inventory.domain.service.InventoryService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
@RefreshScope
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Inventory> getInventories() {
        return (List<Inventory>) inventoryRepository.findAll();
    }

    @RequestMapping(value = "/{sku}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Inventory getInventoryBySku(@PathVariable("sku") final String sku) {
        return inventoryRepository.findBySku(sku).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory addInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.addInventory(inventoryDTO);
    }

    @RequestMapping(value = "/lock", method = RequestMethod.PUT, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory lockInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.lockInventory(inventoryDTO);
    }

    @RequestMapping(value = "/unlock", method = RequestMethod.PUT, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory unlockInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.unlockInventory(inventoryDTO);
    }

    @RequestMapping(value = "/deduct", method = RequestMethod.PUT, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory deductInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.deductInventory(inventoryDTO);
    }


    //思考题：多个lockEvent的批量锁定要不要设计？要设计的话API怎么设计？
    @RequestMapping(value = "/{sku}/lockEvents", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<Inventory> lockInventory(@PathVariable("sku") final String sku,
                                                   @RequestBody InventoryCommandDTO inventoryCommandDTO) {
        System.out.println("inventoryCommandDTO: "+ToStringBuilder.reflectionToString(inventoryCommandDTO));
        InventoryDTO inventoryDTO = new InventoryDTO(sku, inventoryCommandDTO);

        return new ResponseEntity(inventoryService.lockInventory(inventoryDTO), HttpStatus.CREATED);

    }
}
