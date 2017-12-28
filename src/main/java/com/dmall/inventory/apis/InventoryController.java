package com.dmall.inventory.apis;

import com.dmall.inventory.dao.InventoryRepository;
import com.dmall.inventory.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/inventories")
@RefreshScope
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public List<Inventory> getInventories() {
        return (List<Inventory>) inventoryRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Inventory getInventoryById(@PathVariable("id") final Long id) {
        return inventoryRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory createInventory(@RequestBody Inventory inventory) {
        Inventory savedInventory = inventoryRepository.save(inventory);
        return savedInventory;
    }
}
