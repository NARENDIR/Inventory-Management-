package com.example.Inventory;

import com.example.inventory.model.InventoryItem;
import com.example.inventory.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class InventoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(inventoryController).build();
    }

    @Test
    public void testAddInventoryItem() throws Exception {
        InventoryItem item = new InventoryItem();
        item.setName("Test Item");
        item.setDescription("Description");
        item.setStockLevel(10);

        when(inventoryService.addInventoryItem(any(InventoryItem.class))).thenReturn(item);

        mockMvc.perform(post("/inventory/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Item\",\"description\":\"Description\",\"stockLevel\":10}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Test Item"));
    }

    // Similarly, write tests for other controller methods (update, delete, getAll, getById)
}

