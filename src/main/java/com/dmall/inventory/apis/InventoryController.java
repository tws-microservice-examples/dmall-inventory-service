package com.dmall.inventory.apis;

import com.dmall.inventory.apis.common.NotFoundException;
import com.dmall.inventory.dao.InventoryRepository;
import com.dmall.inventory.domain.model.Inventory;
import com.dmall.inventory.domain.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
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
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

}
