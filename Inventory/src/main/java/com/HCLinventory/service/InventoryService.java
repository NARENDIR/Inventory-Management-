package com.HCLinventory.service;

import com.example.inventory.model.InventoryItem;

import java.util.List;

public interface InventoryService {

    InventoryItem addInventoryItem(InventoryItem item);

    InventoryItem updateInventoryItem(Long id, InventoryItem item);

    void deleteInventoryItem(Long id);

    List<InventoryItem> getAllInventoryItems();

    InventoryItem getInventoryItemById(Long id);
}

