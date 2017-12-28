package com.dmall.inventory.dao;

import com.dmall.inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
