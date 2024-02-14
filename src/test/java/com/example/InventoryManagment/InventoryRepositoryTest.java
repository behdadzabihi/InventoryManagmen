package com.example.InventoryManagment;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InventoryRepositoryTest {

    @Mock
    InventoryRepositoryImp repository;

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
}
