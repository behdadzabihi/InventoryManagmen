package com.example.InventoryManagment.controller;

import com.example.InventoryManagment.Inventory;
import com.example.InventoryManagment.InventoryBuilderTest;
import com.example.InventoryManagment.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InventoryControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryService inventoryService;

    private final InventoryBuilderTest builder=new InventoryBuilderTest();

    @Test
    public void should_saveInventory() throws Exception {

        // arrange
        Inventory inventory=builder.build();
        when(inventoryService.save(any(Inventory.class))).thenReturn(inventory);

        //act & assert
        mockMvc.perform(post("/inventory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inventory)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists()) // Assuming your Inventory class has an 'id' field
                .andExpect(jsonPath("$.product").value(inventory.getProduct())) // Adjust based on your Inventory fields
                .andExpect(jsonPath("$.available").value(inventory.getAvailable()))
                .andExpect(jsonPath("$.unitPrice").value(inventory.getUnitPrice()));
           }

           @Test
           public void should_updateInventory() throws Exception {
            Inventory inventory=builder.build();
               inventory.setId(2);
               inventory.setProduct("samsung");
               inventory.setAvailable(false);
               inventory.setUnitPrice(1200.0);
             when(inventoryService.update(any(Inventory.class))).thenReturn(inventory);

            //act & assert
               mockMvc.perform(put("/inventory")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(new ObjectMapper().writeValueAsString(inventory)))
                       .andExpect(status().isOk())
                       .andExpect(jsonPath("$.id").value(inventory.getId()));
           }

    @Test
    public void should_findInventoryWithId() throws Exception {
        Integer id=1;
        Inventory inventory=builder.build();
        when(inventoryService.findBy(eq(id))).thenReturn(inventory);

        //act & assert
        mockMvc.perform(put("/inventory/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inventory)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(inventory.getId()));
    }

    @Test
    public void should_deleteInventoryWithId() throws Exception {

        //arrange
        Integer id=1;

        //act & assert
        mockMvc.perform(delete("/inventory/{id}",id))
                .andExpect(status().isOk());

        verify(inventoryService,times(1)).delete(eq(id));
    }
}
