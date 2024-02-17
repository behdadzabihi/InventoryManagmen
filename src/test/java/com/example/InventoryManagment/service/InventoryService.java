package com.example.InventoryManagment.service;

import com.example.InventoryManagment.Inventory;
import org.springframework.stereotype.Service;


public interface InventoryService {

     Inventory save(Inventory inventory);
     Inventory update(Inventory inventory);
     void  delete(Integer id);
    Inventory findBy(Integer id);

}
