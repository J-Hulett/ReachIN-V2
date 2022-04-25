package com.reachIN.ReachIN.models;

import java.time.LocalDateTime;

public class InventoryItem {

    private int itemId;
    private String itemName;
    private LocalDateTime timeAdded;
    private double quantity;
    private int unitId;

    public InventoryItem(int itemId, String itemName, LocalDateTime timeAdded, double quantity, int unitId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.timeAdded = timeAdded;
        this.quantity = quantity;
        this.unitId = unitId;
    }

    public InventoryItem(){}

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalDateTime timeAdded) {
        this.timeAdded = timeAdded;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}
