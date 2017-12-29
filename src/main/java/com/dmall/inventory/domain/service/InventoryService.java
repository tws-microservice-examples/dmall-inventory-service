package com.dmall.inventory.domain.service;

import com.dmall.inventory.dao.InventoryRepository;
import com.dmall.inventory.domain.model.Inventory;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory addInventory(Inventory inventory) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findBySku(inventory.getSku());
        if (inventoryOptional.isPresent()) {
            inventoryOptional.get().addQuantity(inventory.getQuantity());
            return inventoryRepository.save(inventoryOptional.get());
        }
        return inventoryRepository.save(inventory);
    }
}
