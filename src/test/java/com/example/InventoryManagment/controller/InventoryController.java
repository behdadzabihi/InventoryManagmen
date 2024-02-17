package com.example.InventoryManagment.controller;

import com.example.InventoryManagment.Inventory;
import com.example.InventoryManagment.service.InventoryService;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/inventory")
    public Inventory save(@RequestBody Inventory inventory){
        return inventoryService.save(inventory);
    }

    @PutMapping("/inventory")
    public Inventory update(@RequestBody Inventory inventory){
        return inventoryService.update(inventory);
    }

    @GetMapping("/inventory/{id}")
    public Inventory findBy(@PathVariable Integer id){
        return inventoryService.findBy(id);
    }

    @DeleteMapping("/inventory/{id}")
    public void delete(@PathVariable Integer id){
        inventoryService.delete(id);
    }
}
