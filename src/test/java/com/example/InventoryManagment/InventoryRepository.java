package com.example.InventoryManagment;

import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository {

    Inventory save(Inventory inventory);
}
