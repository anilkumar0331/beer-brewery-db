package com.anilkumar.beer_brewery_db.controller;

import com.anilkumar.beer_brewery_db.models.InventoryModel;
import com.anilkumar.beer_brewery_db.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beer-inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<InventoryModel>> getInventory() {
        return ResponseEntity.ok(this.inventoryService.getAllInventory());
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<InventoryModel> getInventoryById(@PathVariable Long id) {
        return ResponseEntity.ok(this.inventoryService.getInventoryById(id));
    }
}
