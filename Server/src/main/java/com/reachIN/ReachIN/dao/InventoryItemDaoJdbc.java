package com.reachIN.ReachIN.dao;

import com.reachIN.ReachIN.models.InventoryItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryItemDaoJdbc implements InventoryItemDAO{

    private JdbcTemplate jdbcTemplate;
    public InventoryItemDaoJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        List<InventoryItem> inventoryItems = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM item;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            InventoryItem item = mapRowToInventoryItem(results);
            inventoryItems.add(item);
        }
        return inventoryItems;
    }

    @Override
    public InventoryItem getInventoryItem(int itemId) {
        InventoryItem inventoryItem = new InventoryItem();
        String sql = "SELECT * " +
                "FROM item " +
                "WHERE item_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, itemId);
        if(result.next()){
            inventoryItem = mapRowToInventoryItem(result);
        }
        return inventoryItem;
    }

    @Override
    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        String sql = "INSERT INTO item (item_name, time_added, quantity, unit_Id) " +
                "VALUES (?, ?, ?, ? ) RETURNING item_id;";
        int newID = jdbcTemplate.queryForObject(sql, int.class, inventoryItem.getItemName(), inventoryItem.getTimeAdded(),
                inventoryItem.getQuantity(), inventoryItem.getUnitId());
        return getInventoryItem(newID);
    }

    @Override
    public boolean updateInventoryItem(int itemId, InventoryItem inventoryItem) {
        String sql = "UPDATE item " +
                "SET item_name = ?, time_added = ?, quantity = ?, unit_id = ? " +
                "WHERE item_id = ?;";
        return jdbcTemplate.update(sql, inventoryItem.getItemName(), inventoryItem.getTimeAdded(), inventoryItem.getQuantity(),
                inventoryItem.getUnitId(), itemId) == 1;
    }

    @Override
    public boolean deleteInventoryItem(int itemId) {
        String sql = "DELETE FROM item WHERE item_id = ?;";
        return jdbcTemplate.update(sql, itemId) == 1;
    }

    public InventoryItem mapRowToInventoryItem(SqlRowSet results){
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setItemId(results.getInt("item_id"));
        inventoryItem.setItemName(results.getString("item_name"));
        inventoryItem.setTimeAdded(results.getTimestamp("time_added").toLocalDateTime());
        inventoryItem.setQuantity(results.getDouble("quantity"));
        inventoryItem.setUnitId(results.getInt("unit_id"));

        return inventoryItem;
    }
}
