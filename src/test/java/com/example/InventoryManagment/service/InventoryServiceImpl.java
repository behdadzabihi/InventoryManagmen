package com.example.InventoryManagment.service;

import com.example.InventoryManagment.Inventory;
import com.example.InventoryManagment.repo.InventoryRepository;

public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void delete(Integer id) {
        inventoryRepository.delete(id);
    }

    @Override
    public Inventory findBy(Integer id) {
        return inventoryRepository.findById(id);
    }
}

