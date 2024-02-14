package com.example.InventoryManagment;

public class InventoryRepositoryImp implements InventoryRepository {
    @Override
    public Inventory save(Inventory inventory) {
        InventoryBuilderTest builder=new InventoryBuilderTest();
        inventory=builder.build();
        return inventory;
    }
}
