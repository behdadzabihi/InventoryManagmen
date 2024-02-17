package com.example.InventoryManagment.service;

import com.example.InventoryManagment.Inventory;
import com.example.InventoryManagment.InventoryBuilderTest;
import com.example.InventoryManagment.repo.InventoryRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    private InventoryService inventoryService;

    InventoryBuilderTest builder;

    @Before
    public void setUp() {
        inventoryService = new InventoryServiceImpl(inventoryRepository);
        builder = new InventoryBuilderTest();
    }

    @Test
    public void should_saveInventory() {
        // Arrange
        Inventory inventory = builder.build();
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        // Act
        Inventory result = inventoryService.save(inventory);

        // Assert
        assertEquals(inventory, result);
        verify(inventoryRepository, times(1)).save(any(Inventory.class));
    }

    @Test
    public void should_updateInventory(){

        //arrange
        Inventory inventory=builder.build();
        inventory.setId(2);
        inventory.setProduct("samsung");
        inventory.setAvailable(false);
        inventory.setUnitPrice(1200.0);
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        //act
        Inventory result=inventoryService.update(inventory);

        //assert
        assertThat(result).isEqualTo(inventory);
        verify(inventoryRepository,times(1)).save(any(Inventory.class));
    }

    @Test
    public void should_returnInventoryWithId(){
        //arrange
        Integer id=1;
        Inventory inventory=builder.build();
        when(inventoryRepository.findById(any(Integer.class))).thenReturn(inventory);

        //act
        Inventory result=inventoryService.findBy(id);

        //assert
        assertThat(result).isEqualTo(inventory);
        verify(inventoryRepository,times(1)).findById(any(Integer.class));
    }


    @Test
    public void should_deleteInventoryWithId(){
        //arrange
        Integer id=1;

        //act
       inventoryService.delete(id);

        //assert
        verify(inventoryRepository,times(1)).delete(any(Integer.class));
    }
}
