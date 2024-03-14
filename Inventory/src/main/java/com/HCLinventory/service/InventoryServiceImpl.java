package com.HCLinventory.service;


import com.example.inventory.model.InventoryItem;
import com.example.inventory.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Override
    public InventoryItem addInventoryItem(InventoryItem item) {
        return inventoryItemRepository.save(item);
    }

    @Override
    public InventoryItem updateInventoryItem(Long id, InventoryItem item) {
        if (!inventoryItemRepository.existsById(id)) {
            // Handle exception
        }
        item.setId(id);
        return inventoryItemRepository.save(item);
    }

    @Override
    public void deleteInventoryItem(Long id) {
        inventoryItemRepository.deleteById(id);
    }

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }

    @Override
    public InventoryItem getInventoryItemById(Long id) {
        return inventoryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory Item not found with id: " + id));
    }
}

