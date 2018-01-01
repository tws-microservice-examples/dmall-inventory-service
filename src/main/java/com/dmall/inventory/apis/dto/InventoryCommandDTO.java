package com.dmall.inventory.apis.dto;

public class InventoryCommandDTO {


    private Integer quantity;


    public Integer getQuantity() {
        return quantity;
    }

    public enum Commands {
        LOCK
    }
}
