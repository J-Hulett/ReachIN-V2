package com.reachIN.ReachIN.controllers;


import com.reachIN.ReachIN.dao.InventoryItemDAO;
import com.reachIN.ReachIN.models.InventoryItem;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class InventoryItemController {

    private InventoryItemDAO inventoryItemDAO;

    public InventoryItemController(InventoryItemDAO dao){
        this.inventoryItemDAO = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
        public List<InventoryItem> getAllItems(){
            return inventoryItemDAO.getAllInventoryItems();
        }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
        public InventoryItem getItemById(@PathVariable int id){
            return inventoryItemDAO.getInventoryItem(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public InventoryItem createItem(@RequestBody InventoryItem inventoryItem){
        return inventoryItemDAO.createInventoryItem(inventoryItem);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public boolean updateItem(@RequestBody InventoryItem inventoryItem, @PathVariable int id){
        return inventoryItemDAO.updateInventoryItem(id, inventoryItem);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteItem(@PathVariable int id){
        return inventoryItemDAO.deleteInventoryItem(id);
    }

}
