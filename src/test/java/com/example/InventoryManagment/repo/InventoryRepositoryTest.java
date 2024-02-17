package com.example.InventoryManagment.repo;


import com.example.InventoryManagment.Inventory;
import com.example.InventoryManagment.InventoryBuilderTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InventoryRepositoryTest {

    @Mock
    InventoryRepository repository;

    InventoryBuilderTest builder;
    public InventoryRepositoryTest(){
        builder=new InventoryBuilderTest();
    }

    @Test
    public void should_createNewInventory(){
        // Arrange
        Inventory inventory = builder.build(); // Build an inventory object using your builder
        when(repository.save(any(Inventory.class))).thenReturn(inventory); // Define what the mock should return

        // Act
        Inventory result = repository.save(inventory);

        // Assert
        assertThat(result).isEqualTo(inventory); // Use AssertJ to assert that the returned inventory is the same as the one we passed in
        verify(repository).save(inventory); // Verify that the save method was called with the correct argument
    }

    @Test
    public void should_deleteInventory_WithId(){
        //arrange
        Integer id=1;

        //act
        repository.delete(id);

        //assert
        verify(repository,times(1)).delete(id);

    }
    @Test
    public void should_returnInventoryWhenGivenId(){
        //arrange
        Integer id=1;
        Inventory inventory=builder.build();
        when(repository.findById(any(Integer.class))).thenReturn(inventory);

        //act
        Inventory result=repository.findById(id);

        //assert
        assertThat(result).isEqualTo(inventory);
        verify(repository,times(1)).findById(id);
    }
}
