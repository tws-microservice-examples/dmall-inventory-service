package com.dmall.inventory.dao;

import com.dmall.inventory.domain.model.Inventory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> findBySku(String sku);
}
