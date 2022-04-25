package com.reachIN.ReachIN.dao;

import com.reachIN.ReachIN.models.InventoryItem;

import java.util.List;

public interface InventoryItemDAO {

    List<InventoryItem> getAllInventoryItems();
    InventoryItem getInventoryItem(int itemId);
    InventoryItem createInventoryItem(InventoryItem inventoryItem);
    boolean updateInventoryItem(int itemId, InventoryItem inventoryItem);
    boolean deleteInventoryItem(int itemId);

}
