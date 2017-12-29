package com.dmall.inventory.domain.service;

import com.dmall.inventory.apis.common.NotEnoughQuantityException;
import com.dmall.inventory.apis.common.NotFoundException;
import com.dmall.inventory.apis.dto.InventoryDTO;
import com.dmall.inventory.dao.InventoryRepository;
import com.dmall.inventory.domain.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory addInventory(InventoryDTO inventoryDTO) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findBySku(inventoryDTO.getSku());
        if (inventoryOptional.isPresent()) {
            inventoryOptional.get().addQuantity(inventoryDTO.getQuantity());
            return inventoryRepository.save(inventoryOptional.get());
        }

        return saveNewInventory(inventoryDTO);
    }

    private Inventory saveNewInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        inventory.setSku(inventoryDTO.getSku());
        inventory.setCurrentQuantity(inventoryDTO.getQuantity());
        inventory.setLockedQuantity(0);
        inventory.setWarehouse(inventoryDTO.getWarehouse());
        return inventoryRepository.save(inventory);
    }

    public Inventory lockInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findBySku(inventoryDTO.getSku()).orElseThrow(NotFoundException::new);
        if (inventory.getAvailableQuantity() > inventoryDTO.getQuantity()) {
            inventory.lockQuantity(inventoryDTO.getQuantity());
            return inventoryRepository.save(inventory);
        }

        throw new NotEnoughQuantityException();
    }
}
