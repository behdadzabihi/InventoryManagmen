package com.example.InventoryManagment.repo;

import com.example.InventoryManagment.Inventory;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository {

    Inventory save(Inventory inventory);
    void delete(Integer id);
    Inventory findById(Integer id);
}
