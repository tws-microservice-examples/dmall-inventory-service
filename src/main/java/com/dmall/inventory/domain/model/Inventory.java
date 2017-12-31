
package com.dmall.inventory.domain.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sku;
    private String warehouse;
    private Integer currentQuantity;
    private Integer lockedQuantity;

    public Inventory() {}

    public Inventory(Long id, String sku, String warehouse, Integer currentQuantity, Integer lockedQuantity) {
        this.id = id;
        this.sku = sku;
        this.warehouse = warehouse;
        this.currentQuantity = currentQuantity;
        this.lockedQuantity = lockedQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public Integer getLockedQuantity() {
        return lockedQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public void addQuantity(Integer quantity) {
        setCurrentQuantity(this.currentQuantity + quantity);
    }

    public Integer getAvailableQuantity() {
        return currentQuantity - lockedQuantity;
    }

    public void setLockedQuantity(Integer lockedQuantity) {
        this.lockedQuantity = lockedQuantity;
    }

    public void lockQuantity(Integer quantity) {
        setLockedQuantity(this.lockedQuantity + quantity);
    }

    public void unlockQuantity(Integer quantity) {
        setLockedQuantity(this.lockedQuantity - quantity);
    }

    public void deductQuantity(Integer quantity) {
        setCurrentQuantity(this.currentQuantity - quantity);
    }
}



