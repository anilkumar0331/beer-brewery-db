package com.anilkumar.beer_brewery_db.services;

import com.anilkumar.beer_brewery_db.entities.InventoryEntity;
import com.anilkumar.beer_brewery_db.mapper.InventoryMapper;
import com.anilkumar.beer_brewery_db.models.InventoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryMapperService {

    @Autowired
    private InventoryMapper inventoryMapper;

    public InventoryMapperService(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    public InventoryModel convertToModel(InventoryEntity entity) {
        return inventoryMapper.entityToModel(entity);
    }

    public InventoryEntity convertToEntity(InventoryModel model) {
        return inventoryMapper.modelToEntity(model);
    }

    public List<InventoryModel> convertToModelList(List<InventoryEntity> entityList) {
        return entityList.stream().map(inventoryMapper::entityToModel).collect(Collectors.toList());
    }

}