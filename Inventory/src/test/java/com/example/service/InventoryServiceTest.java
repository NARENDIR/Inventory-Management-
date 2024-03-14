package com.example.service;

import com.example.inventory.model.InventoryItem;
import com.example.inventory.repository.InventoryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InventoryServiceTest {

    @Mock
    private InventoryItemRepository inventoryItemRepository;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddInventoryItem() {
        InventoryItem item = new InventoryItem();
        item.setName("Test Item");
        item.setDescription("Description");
        item.setStockLevel(10);

        when(inventoryItemRepository.save(item)).thenReturn(item);

        InventoryItem savedItem = inventoryService.addInventoryItem(item);
        assertEquals("Test Item", savedItem.getName());
    }

    // Similarly, write tests for other service methods (update, delete, getAll, getById)
}

