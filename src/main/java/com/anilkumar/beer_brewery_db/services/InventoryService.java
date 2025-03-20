package com.anilkumar.beer_brewery_db.services;

import com.anilkumar.beer_brewery_db.entities.InventoryEntity;
import com.anilkumar.beer_brewery_db.models.InventoryModel;
import com.anilkumar.beer_brewery_db.repo.InventoryRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private InventoryRepoI inventoryRepository;
    private InventoryMapperService inventoryMapperService;

    @Autowired
    public InventoryService(InventoryRepoI inventoryRepository, InventoryMapperService inventoryMapperService) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryMapperService = inventoryMapperService;
    }

    public List<InventoryModel> getAllInventory() {
        List<InventoryEntity> inventoryEntities = inventoryRepository.findAll();
        return inventoryMapperService.convertToModelList(inventoryEntities);
    }

    public InventoryModel getInventoryById(Long id) {
        InventoryEntity entity = inventoryRepository.findById(id).orElse(null);
        return inventoryMapperService.convertToModel(entity);
    }

}
