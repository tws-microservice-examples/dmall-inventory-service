
package com.dmall.inventory.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sku;
    private String warehouse;
    private Integer currentQuantity;
    private Integer lockedQuantity;

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
}



